/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Categoria;
import Modelos.Coneccion;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryUsuario implements IBaseCrud<Usuario> {

    @Override
    public boolean crear(Usuario entidad) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para insertar un nuevo usuario
            String sql = "INSERT INTO usuario (nombre, contrasena, correo_electronico, hobbie, descripcion, temas_de_interes, gustos, tipo_usuario, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, entidad.getNombre());
            pstmt.setString(2, entidad.getContrasena());
            pstmt.setString(3, entidad.getCorreoElectronico());
            pstmt.setString(4, entidad.getHobbie());
            pstmt.setString(5, entidad.getDescripcion());
            pstmt.setString(6, entidad.getTemasDeInteres());
            pstmt.setString(7, entidad.getGustos());
            pstmt.setLong(8, entidad.getTipoUsuario());
            pstmt.setString(9, entidad.getFoto());

            // Ejecutar la sentencia
            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Usuario eliminar(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        Usuario usuarioAntesDeEliminar = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Consultar el usuario antes de eliminar
            usuarioAntesDeEliminar = encontrarPorId(id);

            // Crear la sentencia SQL para eliminar un usuario
            String sql = "DELETE FROM usuario WHERE id_usuario = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a eliminar
            pstmt.setLong(1, id);

            // Ejecutar la sentencia
            int filasEliminadas = pstmt.executeUpdate();
            return filasEliminadas > 0 ? usuarioAntesDeEliminar : null;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Usuario entidadActualizar) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para actualizar un usuario
            String sql = "UPDATE usuario SET nombre = ?, contrasena = ?, correo_electronico = ?, hobbie = ?, descripcion = ?, temas_de_interes = ?, gustos = ?, tipo_usuario = ?, foto = ? WHERE id_usuario = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, entidadActualizar.getNombre());
            pstmt.setString(2, entidadActualizar.getContrasena());
            pstmt.setString(3, entidadActualizar.getCorreoElectronico());
            pstmt.setString(4, entidadActualizar.getHobbie());
            pstmt.setString(5, entidadActualizar.getDescripcion());
            pstmt.setString(6, entidadActualizar.getTemasDeInteres());
            pstmt.setString(7, entidadActualizar.getGustos());
            pstmt.setLong(8, entidadActualizar.getTipoUsuario());
            pstmt.setString(9, entidadActualizar.getFoto());
            pstmt.setLong(10, entidadActualizar.getIdUsuario());

            // Ejecutar la sentencia
            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> listar() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para listar todos los usuarios
            String sql = "SELECT id_usuario, nombre, contrasena, correo_electronico, hobbie, descripcion, temas_de_interes, gustos, tipo_usuario, foto FROM usuario";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Recorrer los resultados
            while (resultado.next()) {
                Long idUsuario = resultado.getLong("id_usuario");
                String nombre = resultado.getString("nombre");
                String contrasena = resultado.getString("contrasena");
                String correoElectronico = resultado.getString("correo_electronico");
                String hobbie = resultado.getString("hobbie");
                String descripcion = resultado.getString("descripcion");
                String temasDeInteres = resultado.getString("temas_de_interes");
                String gustos = resultado.getString("gustos");
                Long tipoUsuario = resultado.getLong("tipo_usuario");
                String foto = resultado.getString("foto");

                // Crear el objeto Usuario y agregarlo a la lista
                Usuario usuario = new Usuario(idUsuario, nombre, contrasena, correoElectronico, hobbie, descripcion, temasDeInteres, gustos, tipoUsuario, foto);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }

    @Override
    public Usuario encontrarPorId(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para encontrar un usuario por ID
            String sql = "SELECT id_usuario, nombre, contrasena, correo_electronico, hobbie, descripcion, temas_de_interes, gustos, tipo_usuario, foto FROM usuario WHERE id_usuario = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a buscar
            pstmt.setLong(1, id);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Verificar si existe un resultado
            if (resultado.next()) {
                long idUsuario = resultado.getLong("id_usuario");
                String nombre = resultado.getString("nombre");
                String contrasena = resultado.getString("contrasena");
                String correoElectronico = resultado.getString("correo_electronico");
                String hobbie = resultado.getString("hobbie");
                String descripcion = resultado.getString("descripcion");
                String temasDeInteres = resultado.getString("temas_de_interes");
                String gustos = resultado.getString("gustos");
                long tipoUsuario = resultado.getLong("tipo_usuario");
                String foto = resultado.getString("foto");

                // Crear el objeto Usuario y retornarlo
                Usuario usuario = new Usuario(idUsuario, nombre, contrasena, correoElectronico, hobbie, descripcion, temasDeInteres, gustos, tipoUsuario, foto);
                return usuario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Usuario encontrarPorCorreoYContrasena(String correo, String Contrasena) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = Coneccion.getConnection();

            String sql = "SELECT id_usuario, nombre, contrasena, correo_electronico, hobbie, descripcion, temas_de_interes, gustos, tipo_usuario, foto FROM usuario WHERE correo_electronico = ? and contrasena = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, correo);
            pstmt.setString(2, Contrasena );

            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                Long idUsuario = resultado.getLong("id_usuario");
                String nombre = resultado.getString("nombre");
                String contrasena = resultado.getString("contrasena");
                String correoElectronico = resultado.getString("correo_electronico");
                String hobbie = resultado.getString("hobbie");
                String descripcion = resultado.getString("descripcion");
                String temasDeInteres = resultado.getString("temas_de_interes");
                String gustos = resultado.getString("gustos");
                Long tipoUsuario = resultado.getLong("tipo_usuario");
                String foto = resultado.getString("foto");

                Usuario temporal = new Usuario(idUsuario, nombre, contrasena, correoElectronico, hobbie, descripcion, temasDeInteres, gustos, tipoUsuario, foto);
                return temporal;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    
     public Usuario encontrarPorCorreo(String correo) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = Coneccion.getConnection();

            String sql = "SELECT id_usuario, nombre, contrasena, correo_electronico, hobbie, descripcion, temas_de_interes, gustos, tipo_usuario, foto FROM usuario WHERE correo_electronico = ?  ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, correo);
         

            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                Long idUsuario = resultado.getLong("id_usuario");
                String nombre = resultado.getString("nombre");
                String contrasena = resultado.getString("contrasena");
                String correoElectronico = resultado.getString("correo_electronico");
                String hobbie = resultado.getString("hobbie");
                String descripcion = resultado.getString("descripcion");
                String temasDeInteres = resultado.getString("temas_de_interes");
                String gustos = resultado.getString("gustos");
                Long tipoUsuario = resultado.getLong("tipo_usuario");
                String foto = resultado.getString("foto");

                Usuario temporal = new Usuario(idUsuario, nombre, contrasena, correoElectronico, hobbie, descripcion, temasDeInteres, gustos, tipoUsuario, foto);
                return temporal;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
