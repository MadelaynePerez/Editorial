/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Comentario;
import Modelos.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryComentario implements IBaseCrud<Comentario>{
    @Override
public boolean crear(Comentario entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para insertar un nuevo comentario
        String sql = "INSERT INTO comentario (texto, id_usuario, id_revista, fecha) VALUES (?, ?, ?, ?)";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidad.getTexto());
        pstmt.setLong(2, entidad.getIdUsuario());
        pstmt.setLong(3, entidad.getIdRevista());
        pstmt.setLong(4, entidad.getFecha());

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
public Comentario eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Consultar el comentario antes de eliminar
        Comentario comentarioAntesDeEliminar = encontrarPorId(id);

        // Crear la sentencia SQL para eliminar un comentario
        String sql = "DELETE FROM comentario WHERE id_comentario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a eliminar
        pstmt.setLong(1, id);

        // Ejecutar la sentencia
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? comentarioAntesDeEliminar : null;

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
public boolean actualizar(Comentario actualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar un comentario
        String sql = "UPDATE comentario SET texto = ?, id_usuario = ?, id_revista = ?, fecha = ? WHERE id_comentario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, actualizar.getTexto());
        pstmt.setLong(2, actualizar.getIdUsuario());
        pstmt.setLong(3, actualizar.getIdRevista());
        pstmt.setLong(4, actualizar.getFecha());
        pstmt.setLong(5, actualizar.getIdComentario());

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
public ArrayList<Comentario> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<Comentario> comentarios = new ArrayList<>();

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todos los comentarios
        String sql = "SELECT id_comentario, texto, id_usuario, id_revista, fecha FROM comentario";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            long idComentario = resultado.getLong("id_comentario");
            String texto = resultado.getString("texto");
            long idUsuario = resultado.getLong("id_usuario");
            long idRevista = resultado.getLong("id_revista");
            long fecha = resultado.getLong("fecha");

            // Crear el objeto Comentario y agregarlo a la lista
            Comentario comentario = new Comentario(idComentario, texto, idUsuario, idRevista, fecha);
            comentarios.add(comentario);
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

    return comentarios;
}

@Override
public Comentario encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar un comentario por ID
        String sql = "SELECT id_comentario, texto, id_usuario, id_revista, fecha FROM comentario WHERE id_comentario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a buscar
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Verificar si existe un resultado
        if (resultado.next()) {
            long idComentario = resultado.getLong("id_comentario");
            String texto = resultado.getString("texto");
            long idUsuario = resultado.getLong("id_usuario");
            long idRevista = resultado.getLong("id_revista");
            long fecha = resultado.getLong("fecha");

            // Crear el objeto Comentario y retornarlo
            Comentario comentario = new Comentario(idComentario, texto, idUsuario, idRevista, fecha);
            return comentario;
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