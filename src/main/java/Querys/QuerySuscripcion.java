/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;


import Modelos.Coneccion;
import Modelos.Suscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QuerySuscripcion implements IBaseCrud<Suscripcion> {
    @Override
public boolean crear(Suscripcion entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "INSERT INTO suscripcion (id_suscripcion, fecha_de_suscripcion, id_revista, id_usuario, activo, me_gusta) VALUES (?, ?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1, entidad.getIdSuscripcion());
        pstmt.setDate(2, entidad.getFechaDeSuscripcion());
        pstmt.setLong(3, entidad.getIdRevista());
        pstmt.setLong(4, entidad.getIdUsuario());
        pstmt.setBoolean(5, entidad.isActivo());
        pstmt.setBoolean(6, entidad.isMeGusta());

        int filasInsertadas = pstmt.executeUpdate();
        return filasInsertadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}
@Override
public Suscripcion eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "DELETE FROM suscripcion WHERE id_suscripcion = ?";
        pstmt = connection.prepareStatement(sql);

        // Obtener la suscripción antes de eliminar
        Suscripcion suscripcionAntesDeEliminar = encontrarPorId(id);

        pstmt.setLong(1, id);
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? suscripcionAntesDeEliminar : null;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}
@Override
public boolean actualizar(Suscripcion entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "UPDATE suscripcion SET fecha_de_suscripcion = ?, id_revista = ?, id_usuario = ?, activo = ?, me_gusta = ? WHERE id_suscripcion = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setDate(1, entidad.getFechaDeSuscripcion());
        pstmt.setLong(2, entidad.getIdRevista());
        pstmt.setLong(3, entidad.getIdUsuario());
        pstmt.setBoolean(4, entidad.isActivo());
        pstmt.setBoolean(5, entidad.isMeGusta());
        pstmt.setLong(6, entidad.getIdSuscripcion());

        int filasActualizadas = pstmt.executeUpdate();
        return filasActualizadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}

@Override
public ArrayList<Suscripcion> listar() {
    ArrayList<Suscripcion> suscripciones = new ArrayList<>();
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultado = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todas las suscripciones
        String sql = "SELECT id_suscripcion, fecha_de_suscripcion, id_revista, id_usuario, activo, me_gusta FROM suscripcion";

        // Preparar el statement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            long idSuscripcion = resultado.getLong("id_suscripcion");
            java.sql.Date fechaDeSuscripcion = resultado.getDate("fecha_de_suscripcion");
            long idRevista = resultado.getLong("id_revista");
            long idUsuario = resultado.getLong("id_usuario");
            boolean activo = resultado.getBoolean("activo");
            boolean meGusta = resultado.getBoolean("me_gusta");

            // Crear el objeto Suscripcion y agregarlo a la lista
            Suscripcion suscripcion = new Suscripcion(idSuscripcion, fechaDeSuscripcion, idRevista, idUsuario, activo, meGusta);
            suscripciones.add(suscripcion);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultado != null) {
                resultado.close();
            }
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

    // Retornar la lista de Suscripciones
    return suscripciones;
}


@Override
public Suscripcion encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultado = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar una suscripción por ID
        String sql = "SELECT id_suscripcion, fecha_de_suscripcion, id_revista, id_usuario, activo, me_gusta FROM suscripcion WHERE id_suscripcion = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        resultado = pstmt.executeQuery();
        if (resultado.next()) {
            long idSuscripcion = resultado.getLong("id_suscripcion");
            java.sql.Date fechaDeSuscripcion = resultado.getDate("fecha_de_suscripcion");
            long idRevista = resultado.getLong("id_revista");
            long idUsuario = resultado.getLong("id_usuario");
            boolean activo = resultado.getBoolean("activo");
            boolean meGusta = resultado.getBoolean("me_gusta");

            // Crear y devolver el objeto Suscripcion
            Suscripcion suscripcion = new Suscripcion(idSuscripcion, fechaDeSuscripcion, idRevista, idUsuario, activo, meGusta);
            return suscripcion;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultado != null) resultado.close();
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}

   
}
