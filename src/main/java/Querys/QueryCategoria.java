/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Categoria;
import Modelos.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class QueryCategoria implements IBaseCrud<Categoria> {

    @Override
    public boolean crear(Categoria entidad) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para insertar una nueva categoría
            String sql = "INSERT INTO categoria (tipo_categoria) VALUES (?)";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setString(1, entidad.getTipoCategoria());

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
    public Categoria eliminar(Long idCategoria) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Encontrar la categoría antes de eliminarla
            Categoria categoriaAntesDeEliminar = encontrarPorId(idCategoria);

            if (categoriaAntesDeEliminar != null) {
                // Crear la sentencia SQL para eliminar una categoría
                String sql = "DELETE FROM categoria WHERE id_categoria = ?";
                pstmt = connection.prepareStatement(sql);

                // Establecer el valor del ID a eliminar
                pstmt.setLong(1, idCategoria);

                // Ejecutar la sentencia
                int filasEliminadas = pstmt.executeUpdate();

                // Verificar si se eliminó la categoría
                if (filasEliminadas > 0) {
                    return categoriaAntesDeEliminar;
                }
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
        return null; // Retornar null si no se encontró o no se pudo eliminar la categoría
    }

    @Override
    public boolean actualizar(Categoria Actualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar
        String sql = "UPDATE categoria SET tipo_categoria = ? WHERE id_categoria = ?";

        // Crear un PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, Actualizar.getTipoCategoria()); // tipo_categoria
        pstmt.setLong(2, Actualizar.getIdCategoria());      // id_categoria

        // Ejecutar la sentencia
        int filasActualizadas = pstmt.executeUpdate();
        return filasActualizadas == 1;

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
    public ArrayList<Categoria> listar() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para listar todas las categorías
            String sql = "SELECT id_categoria, tipo_categoria FROM categoria";

            // Preparar el statement
            pstmt = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Recorrer los resultados
            while (resultado.next()) {
                long idCategoria = resultado.getLong("id_categoria");
                String tipoCategoria = resultado.getString("tipo_categoria");

                // Crear el objeto Categoria y agregarlo a la lista
                Categoria categoria = new Categoria(idCategoria, tipoCategoria);
                categorias.add(categoria);
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

        // Asegúrate de que estás retornando una lista válida de Categoria
        return categorias;
    }

    @Override
    public Categoria encontrarPorId(Long idCategoria) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = Coneccion.getConnection();

            String sql = "SELECT id_categoria, tipo_categoria FROM categoria WHERE id_categoria = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idCategoria);
            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                long id = resultado.getLong("id_categoria");
                String tipoCategoria = resultado.getString("tipo_categoria");

                return new Categoria(id, tipoCategoria);
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
