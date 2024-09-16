/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.TipoDeAnuncio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryTipoDeAnuncio implements IBaseCrud<TipoDeAnuncio>{

   @Override
public boolean crear(TipoDeAnuncio entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para insertar un nuevo tipo de anuncio
        String sql = "INSERT INTO tipo_de_anuncio (tipo_anuncio, precio) VALUES (?, ?)";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidad.getTipoAnuncio());
        pstmt.setDouble(2, entidad.getPrecio());

        // Ejecutar la sentencia
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
public TipoDeAnuncio eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    TipoDeAnuncio tipoAntesDeEliminar = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Consultar el tipo de anuncio antes de eliminar
        tipoAntesDeEliminar = encontrarPorId(id);

        // Crear la sentencia SQL para eliminar un tipo de anuncio
        String sql = "DELETE FROM tipo_de_anuncio WHERE id_tipo_anuncio = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a eliminar
        pstmt.setLong(1, id);

        // Ejecutar la sentencia
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? tipoAntesDeEliminar : null;

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
public boolean actualizar(TipoDeAnuncio entidadActualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar un tipo de anuncio
        String sql = "UPDATE tipo_de_anuncio SET tipo_anuncio = ?, precio = ? WHERE id_tipo_anuncio = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setString(1, entidadActualizar.getTipoAnuncio());
        pstmt.setDouble(2, entidadActualizar.getPrecio());
        pstmt.setLong(3, entidadActualizar.getIdTipoAnuncio());

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
public ArrayList<TipoDeAnuncio> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<TipoDeAnuncio> tiposDeAnuncio = new ArrayList<>();

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todos los tipos de anuncio
        String sql = "SELECT id_tipo_anuncio, tipo_anuncio, precio FROM tipo_de_anuncio";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            Long idTipoAnuncio = resultado.getLong("id_tipo_anuncio");
            String tipoAnuncio = resultado.getString("tipo_anuncio");
            double precio = resultado.getDouble("precio");

            // Crear el objeto TipoDeAnuncio y agregarlo a la lista
            TipoDeAnuncio tipo = new TipoDeAnuncio(idTipoAnuncio, tipoAnuncio, precio);
            tiposDeAnuncio.add(tipo);
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

    return tiposDeAnuncio;
}

@Override
public TipoDeAnuncio encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar un tipo de anuncio por ID
        String sql = "SELECT id_tipo_anuncio, tipo_anuncio, precio FROM tipo_de_anuncio WHERE id_tipo_anuncio = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a buscar
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Verificar si existe un resultado
        if (resultado.next()) {
            Long idTipoAnuncio = resultado.getLong("id_tipo_anuncio");
            String tipoAnuncio = resultado.getString("tipo_anuncio");
            double precio = resultado.getDouble("precio");

            // Crear el objeto TipoDeAnuncio y retornarlo
            TipoDeAnuncio tipo = new TipoDeAnuncio(idTipoAnuncio, tipoAnuncio, precio);
            return tipo;
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
