/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.TipoDeUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryTipoDeUsuario implements IBaseCrud<TipoDeUsuario>{

  @Override
public boolean crear(TipoDeUsuario entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para insertar un nuevo tipo de usuario
        String sql = "INSERT INTO tipo_de_usuario (tipo_de_usuario) VALUES (?)";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del parámetro
        pstmt.setString(1, entidad.getTipoDeUsuario());

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
public TipoDeUsuario eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    TipoDeUsuario tipoDeUsuarioAntesDeEliminar = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Consultar el tipo de usuario antes de eliminar
        tipoDeUsuarioAntesDeEliminar = encontrarPorId(id);

        // Crear la sentencia SQL para eliminar un tipo de usuario
        String sql = "DELETE FROM tipo_de_usuario WHERE id_tipo_usuario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a eliminar
        pstmt.setLong(1, id);

        // Ejecutar la sentencia
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? tipoDeUsuarioAntesDeEliminar : null;

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
public boolean actualizar(TipoDeUsuario entidadActualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar un tipo de usuario
        String sql = "UPDATE tipo_de_usuario SET tipo_de_usuario = ? WHERE id_tipo_usuario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidadActualizar.getTipoDeUsuario());
        pstmt.setLong(2, entidadActualizar.getIdTipoUsuario());

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
public ArrayList<TipoDeUsuario> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<TipoDeUsuario> tiposDeUsuario = new ArrayList<>();

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todos los tipos de usuario
        String sql = "SELECT id_tipo_usuario, tipo_de_usuario FROM tipo_de_usuario";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            long idTipoUsuario = resultado.getLong("id_tipo_usuario");
            String tipoDeUsuario = resultado.getString("tipo_de_usuario");

            // Crear el objeto TipoDeUsuario y agregarlo a la lista
            TipoDeUsuario tipoDeUsuarioObj = new TipoDeUsuario(idTipoUsuario, tipoDeUsuario);
            tiposDeUsuario.add(tipoDeUsuarioObj);
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

    return tiposDeUsuario;
}
@Override
public TipoDeUsuario encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar un tipo de usuario por ID
        String sql = "SELECT id_tipo_usuario, tipo_de_usuario FROM tipo_de_usuario WHERE id_tipo_usuario = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a buscar
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Verificar si existe un resultado
        if (resultado.next()) {
            long idTipoUsuario = resultado.getLong("id_tipo_usuario");
            String tipoDeUsuario = resultado.getString("tipo_de_usuario");

            // Crear el objeto TipoDeUsuario y retornarlo
            TipoDeUsuario tipoDeUsuarioObj = new TipoDeUsuario(idTipoUsuario, tipoDeUsuario);
            return tipoDeUsuarioObj;
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
