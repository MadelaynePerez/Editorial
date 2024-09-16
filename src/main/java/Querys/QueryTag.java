/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.Tag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryTag implements IBaseCrud<Tag>{

   @Override
public boolean crear(Tag entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para insertar un nuevo tag
        String sql = "INSERT INTO tag (etiqueta) VALUES (?)";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidad.getEtiqueta());

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
public Tag eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    Tag tagAntesDeEliminar = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Consultar el tag antes de eliminar
        tagAntesDeEliminar = encontrarPorId(id);

        // Crear la sentencia SQL para eliminar un tag
        String sql = "DELETE FROM tag WHERE id_tag = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a eliminar
        pstmt.setLong(1, id);

        // Ejecutar la sentencia
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? tagAntesDeEliminar : null;

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
public boolean actualizar(Tag entidadActualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar un tag
        String sql = "UPDATE tag SET etiqueta = ? WHERE id_tag = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidadActualizar.getEtiqueta());
        pstmt.setLong(2, entidadActualizar.getIdTag());

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
public ArrayList<Tag> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<Tag> tags = new ArrayList<>();

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todos los tags
        String sql = "SELECT id_tag, etiqueta FROM tag";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            long idTag = resultado.getLong("id_tag");
            String etiqueta = resultado.getString("etiqueta");

            // Crear el objeto Tag y agregarlo a la lista
            Tag tag = new Tag(idTag, etiqueta);
            tags.add(tag);
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

    return tags;
}
@Override
public Tag encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar un tag por ID
        String sql = "SELECT id_tag, etiqueta FROM tag WHERE id_tag = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a buscar
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Verificar si existe un resultado
        if (resultado.next()) {
            long idTag = resultado.getLong("id_tag");
            String etiqueta = resultado.getString("etiqueta");

            // Crear el objeto Tag y retornarlo
            return new Tag(idTag, etiqueta);
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
