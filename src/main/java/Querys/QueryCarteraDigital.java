/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.carteraDigital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryCarteraDigital implements  IBaseCrud<carteraDigital>{

    @Override
public boolean crear(carteraDigital entidad) {
    PreparedStatement preparedStatement = null;
    Connection conexion = null;
    try {
        // Establecer la conexión con la base de datos
        conexion = Coneccion.getConnection();

        // Crear el comando SQL para insertar datos en la tabla 'cartera digital'
        String sql = "INSERT INTO `cartera digital` (id_usuario, saldo) VALUES (?, ?)";

        // Crear el PreparedStatement
        preparedStatement = conexion.prepareStatement(sql);

        // Configurar los valores para el INSERT
        preparedStatement.setLong(1, entidad.getIdUsuario());  // id_usuario
        preparedStatement.setDouble(2, entidad.getSaldo());    // saldo

        // Ejecutar el comando
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión y el PreparedStatement
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}


    @Override
    public carteraDigital eliminar(Long idCartera) {
     Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Establecer la conexión con la base de datos
        connection = Coneccion.getConnection();

        // Crear el comando SQL para eliminar datos de la tabla 'cartera digital'
        String sql = "DELETE FROM `cartera digital` WHERE id_cartera = ?";

        // Crear el PreparedStatement
        preparedStatement = connection.prepareStatement(sql);

        // Configurar el valor para el DELETE
        preparedStatement.setLong(1, idCartera); // id_cartera

        // Ejecutar el comando
        carteraDigital carteraAntesDeEliminar = encontrarPorId(idCartera); // Método para obtener la cartera antes de eliminar
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            return carteraAntesDeEliminar; // Retornar la cartera eliminada si la operación fue exitosa
        }  

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión y el PreparedStatement
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
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
    public boolean actualizar(carteraDigital entidadActualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para actualizar
        String sql = "UPDATE `cartera digital` SET id_usuario = ?, saldo = ? WHERE id_cartera = ?";

        // Crear un PreparedStatement
        pstmt = connection.prepareStatement(sql);

        // Establecer los valores de los parámetros
        pstmt.setLong(1, entidadActualizar.getIdUsuario());  // id_usuario
        pstmt.setDouble(2, entidadActualizar.getSaldo());    // saldo
        pstmt.setLong(3, entidadActualizar.getIdCartera());  // id_cartera

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
    public ArrayList<carteraDigital> listar() {
     Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<carteraDigital> carteras = new ArrayList<>();

    try {
        // Establecer la conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para listar los datos de 'cartera digital'
        String sql = "SELECT id_cartera, id_usuario, saldo FROM `cartera digital`";
        
        // Preparar el statement
        pstmt = connection.prepareStatement(sql);
        
        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();
        
        // Recorrer los resultados
        while (resultado.next()) {
            long idCartera = resultado.getLong("id_cartera");
            long idUsuario = resultado.getLong("id_usuario");
            double saldo = resultado.getDouble("saldo");

            // Crear el objeto Cartera y agregarlo a la lista
            carteraDigital carteraTemporal = new carteraDigital(idCartera, idUsuario, saldo);
            carteras.add(carteraTemporal);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
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

    return carteras;
    }

    @Override
    public carteraDigital encontrarPorId(Long idCartera) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión con la base de datos
        connection = Coneccion.getConnection();

        // Crear la consulta SQL para buscar una cartera por ID
        String sql = "SELECT id_cartera, id_usuario, saldo FROM `cartera digital` WHERE id_cartera = ?";
        
        // Preparar el statement
        pstmt = connection.prepareStatement(sql);
        
        // Establecer el valor del ID que queremos buscar
        pstmt.setLong(1, idCartera);
        
        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();
        
        // Verificar si existe un resultado
        if (resultado.next()) {
            long idCarteraSeleccionado = resultado.getLong("id_cartera");
            long idUsuario = resultado.getLong("id_usuario");
            double saldo = resultado.getDouble("saldo");

            // Crear el objeto Cartera y retornarlo
            carteraDigital carteraTemporal = new carteraDigital(idCarteraSeleccionado, idUsuario, saldo);
            return carteraTemporal;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar los recursos
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