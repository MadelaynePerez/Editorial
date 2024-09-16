/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.Costo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryCosto implements IBaseCrud<Costo>{
@Override
public boolean crear(Costo entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para insertar un nuevo costo
        String sql = "INSERT INTO costo (costo_por_revista) VALUES (?)";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setDouble(1, entidad.getCostoPorRevista());

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
public Costo eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Consultar el costo antes de eliminar
        Costo costoAntesDeEliminar = encontrarPorId(id);

        // Crear la sentencia SQL para eliminar un costo
        String sql = "DELETE FROM costo WHERE id_costo = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a eliminar
        pstmt.setLong(1, id);

        // Ejecutar la sentencia
        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? costoAntesDeEliminar : null;

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
public boolean actualizar(Costo actualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar un costo
        String sql = "UPDATE costo SET costo_por_revista = ? WHERE id_costo = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setDouble(1, actualizar.getCostoPorRevista());
        pstmt.setLong(2, actualizar.getIdCosto());

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
public ArrayList<Costo> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<Costo> costos = new ArrayList<>();

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar todos los costos
        String sql = "SELECT id_costo, costo_por_revista FROM costo";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Recorrer los resultados
        while (resultado.next()) {
            long idCosto = resultado.getLong("id_costo");
            double costoPorRevista = resultado.getDouble("costo_por_revista");

            // Crear el objeto Costo y agregarlo a la lista
            Costo costo = new Costo(idCosto, costoPorRevista);
            costos.add(costo);
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

    return costos;
}

@Override
public Costo encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar un costo por ID
        String sql = "SELECT id_costo, costo_por_revista FROM costo WHERE id_costo = ?";

        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer el valor del ID a buscar
        pstmt.setLong(1, id);

        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();

        // Verificar si existe un resultado
        if (resultado.next()) {
            long idCosto = resultado.getLong("id_costo");
            double costoPorRevista = resultado.getDouble("costo_por_revista");

            // Crear el objeto Costo y retornarlo
            Costo costo = new Costo(idCosto, costoPorRevista);
            return costo;
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
