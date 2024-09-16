/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryPago implements IBaseCrud<pago> {

    @Override
    public boolean crear(pago entidad) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para insertar un nuevo pago
            String sql = "INSERT INTO pago (id) VALUES (?)";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID
            pstmt.setLong(1, entidad.getId());

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
    public pago eliminar(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Consultar el pago antes de eliminar
            pago pagoAntesDeEliminar = encontrarPorId(id);

            // Crear la sentencia SQL para eliminar un pago
            String sql = "DELETE FROM pago WHERE id = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a eliminar
            pstmt.setLong(1, id);

            // Ejecutar la sentencia
            int filasEliminadas = pstmt.executeUpdate();
            return filasEliminadas > 0 ? pagoAntesDeEliminar : null;

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
    public boolean actualizar(pago actualizar) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para actualizar un pago
            String sql = "UPDATE pago SET id = ? WHERE id = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setLong(1, actualizar.getId());
            pstmt.setLong(2, actualizar.getId()); // Esta línea está redundante y se puede eliminar si no necesitas actualizar el ID

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
    public ArrayList<pago> listar() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ArrayList<pago> pagos = new ArrayList<>();

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para listar todos los pagos
            String sql = "SELECT id FROM pago";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Recorrer los resultados
            while (resultado.next()) {
                long id = resultado.getLong("id");

                // Crear el objeto Pago y agregarlo a la lista
                pago pagoo = new pago(id);
                pagos.add(pagoo);
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

        return pagos;
    }

    @Override
    public pago encontrarPorId(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para encontrar un pago por ID
            String sql = "SELECT id FROM pago WHERE id = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a buscar
            pstmt.setLong(1, id);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Verificar si existe un resultado
            if (resultado.next()) {
                long idPago = resultado.getLong("id");

                // Crear el objeto Pago y retornarlo
                pago pago = new pago(idPago);
                return pago;
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
