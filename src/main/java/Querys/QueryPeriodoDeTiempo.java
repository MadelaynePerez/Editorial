/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.PeriodoDeTiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryPeriodoDeTiempo implements IBaseCrud<PeriodoDeTiempo> {

    @Override
    public boolean crear(PeriodoDeTiempo entidad) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para insertar un nuevo periodo de tiempo
            String sql = "INSERT INTO periodo_de_tiempo (id_periodo_de_tiempo, periodo_disponible, tipo) VALUES (?, ?, ?)";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setLong(1, entidad.getIdPeriodoDeTiempo());
            pstmt.setLong(2, entidad.getPeriodoDisponible());
            pstmt.setString(3, entidad.getTipo());

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
    public PeriodoDeTiempo eliminar(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Consultar el periodo de tiempo antes de eliminar
            PeriodoDeTiempo periodoAntesDeEliminar = encontrarPorId(id);

            // Crear la sentencia SQL para eliminar un periodo de tiempo
            String sql = "DELETE FROM periodo_de_tiempo WHERE id_periodo_de_tiempo = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a eliminar
            pstmt.setLong(1, id);

            // Ejecutar la sentencia
            int filasEliminadas = pstmt.executeUpdate();
            return filasEliminadas > 0 ? periodoAntesDeEliminar : null;

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
    public boolean actualizar(PeriodoDeTiempo actualizar) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para actualizar un periodo de tiempo
            String sql = "UPDATE periodo_de_tiempo SET periodo_disponible = ?, tipo = ? WHERE id_periodo_de_tiempo = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            pstmt.setLong(1, actualizar.getPeriodoDisponible());
            pstmt.setString(2, actualizar.getTipo());
            pstmt.setLong(3, actualizar.getIdPeriodoDeTiempo());

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
    public ArrayList<PeriodoDeTiempo> listar() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ArrayList<PeriodoDeTiempo> periodos = new ArrayList<>();

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para listar todos los periodos de tiempo
            String sql = "SELECT id_periodo_de_tiempo, periodo_disponible, tipo FROM periodo_de_tiempo";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Recorrer los resultados
            while (resultado.next()) {
                long id = resultado.getLong("id_periodo_de_tiempo");
                long periodoDisponible = resultado.getLong("periodo_disponible");
                String tipo = resultado.getString("tipo");

                // Crear el objeto PeriodoDeTiempo y agregarlo a la lista
                PeriodoDeTiempo periodo = new PeriodoDeTiempo(id, periodoDisponible, tipo);
                periodos.add(periodo);
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

        return periodos;
    }

    @Override
    public PeriodoDeTiempo encontrarPorId(Long id) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para encontrar un periodo de tiempo por ID
            String sql = "SELECT id_periodo_de_tiempo, periodo_disponible, tipo FROM periodo_de_tiempo WHERE id_periodo_de_tiempo = ?";

            // Preparar el PreparedStatement
            pstmt = connection.prepareStatement(sql);

            // Establecer el valor del ID a buscar
            pstmt.setLong(1, id);

            // Ejecutar la consulta
            ResultSet resultado = pstmt.executeQuery();

            // Verificar si existe un resultado
            if (resultado.next()) {
                long idPeriodo = resultado.getLong("id_periodo_de_tiempo");
                long periodoDisponible = resultado.getLong("periodo_disponible");
                String tipo = resultado.getString("tipo");

                // Crear el objeto PeriodoDeTiempo y retornarlo
                PeriodoDeTiempo periodo = new PeriodoDeTiempo(idPeriodo, periodoDisponible, tipo);
                return periodo;
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
