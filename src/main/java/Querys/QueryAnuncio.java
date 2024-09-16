/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Anuncio;
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
public class QueryAnuncio implements IBaseCrud<Anuncio> {

    @Override
    public boolean crear(Anuncio entidad) {
        PreparedStatement preparedStatement = null;
        Connection conexion = null;  // Cambiado a "conexion"
        try {
            // Establecer la conexión con la base de datos
            conexion = Coneccion.getConnection();

            // Crear el comando SQL
            String sql = "INSERT INTO anuncios (fecha_inicio, id_periodo_de_tiempo, id_usuario, activo, tipo_anuncio, texto, ruta_imagen) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(sql);

            // Configurar los valores
            preparedStatement.setDate(1, new java.sql.Date(entidad.getFechaInicio().getTime()));
            preparedStatement.setLong(2, entidad.getIdPeriodoDeTiempo());
            preparedStatement.setLong(3, entidad.getIdUsuario());
            preparedStatement.setBoolean(4, entidad.isActivo());
            preparedStatement.setLong(5, entidad.getTipoAnuncio());
            preparedStatement.setString(6, entidad.getTexto());
            preparedStatement.setString(7, entidad.getRutaImagen());

            // Ejecutar la instrucción
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();  // Uso de la variable correcta
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Anuncio eliminar(Long idAnuncio) {
    Connection conexion = null;
    PreparedStatement preparedStatement = null;

    try {
        conexion = Coneccion.getConnection();
        String sql = "DELETE FROM anuncios WHERE id_anuncio = ?";
        preparedStatement = conexion.prepareStatement(sql);

        // Configurar el parámetro
        preparedStatement.setLong(1, idAnuncio);

        Anuncio anuncioAntesDeEliminar = encontrarPorId(idAnuncio);
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            return anuncioAntesDeEliminar;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
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
    return null;
}

    @Override
    public boolean actualizar(Anuncio entidadActualizar) {
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            conexion = Coneccion.getConnection();
            String sql = "UPDATE anuncios SET fecha_inicio = ?, id_periodo_de_tiempo = ?, id_usuario = ?, activo = ?, tipo_anuncio = ?, texto = ?, ruta_imagen = ? WHERE id_anuncio = ?";
            pstmt = conexion.prepareStatement(sql);

            pstmt.setDate(1, new java.sql.Date(entidadActualizar.getFechaInicio().getTime()));
            pstmt.setLong(2, entidadActualizar.getIdPeriodoDeTiempo());
            pstmt.setLong(3, entidadActualizar.getIdUsuario());
            pstmt.setBoolean(4, entidadActualizar.isActivo());
            pstmt.setLong(5, entidadActualizar.getTipoAnuncio());
            pstmt.setString(6, entidadActualizar.getTexto());
            pstmt.setString(7, entidadActualizar.getRutaImagen());
            pstmt.setLong(8, entidadActualizar.getIdAnuncio());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
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
    public ArrayList<Anuncio> listar() {
        Connection conexion = null;
        PreparedStatement pstmt = null;
        ArrayList<Anuncio> anuncios = new ArrayList<>();

        try {
            conexion = Coneccion.getConnection();
            String sql = "SELECT id_anuncio, fecha_inicio, id_periodo_de_tiempo, id_usuario, activo, tipo_anuncio, texto, ruta_imagen FROM anuncios";
            pstmt = conexion.prepareStatement(sql);

            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                long idAnuncio = resultado.getLong("id_anuncio");
                java.sql.Date fechaInicio = resultado.getDate("fecha_inicio");
                long idPeriodoDeTiempo = resultado.getLong("id_periodo_de_tiempo");
                long idUsuario = resultado.getLong("id_usuario");
                boolean activo = resultado.getBoolean("activo");
                long tipoAnuncio = resultado.getLong("tipo_anuncio");
                String texto = resultado.getString("texto");
                String rutaImagen = resultado.getString("ruta_imagen");

                Anuncio anuncioTemporal = new Anuncio(idAnuncio, fechaInicio, idPeriodoDeTiempo, idUsuario, activo, tipoAnuncio, texto, rutaImagen);
                anuncios.add(anuncioTemporal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return anuncios;
    }


    @Override
    public Anuncio encontrarPorId(Long idAnuncio) {
    Connection conexion = null;
    PreparedStatement pstmt = null;

    try {
        conexion = Coneccion.getConnection();
        String sql = "SELECT id_anuncio, fecha_inicio, id_periodo_de_tiempo, id_usuario, activo, tipo_anuncio, texto, ruta_imagen FROM anuncios WHERE id_anuncio = ?";
        pstmt = conexion.prepareStatement(sql);

        pstmt.setLong(1, idAnuncio);

        ResultSet resultado = pstmt.executeQuery();

        if (resultado.next()) {
            long idAnuncioSeleccionado = resultado.getLong("id_anuncio");
            java.sql.Date fechaInicio = resultado.getDate("fecha_inicio");
            long idPeriodoDeTiempo = resultado.getLong("id_periodo_de_tiempo");
            long idUsuario = resultado.getLong("id_usuario");
            boolean activo = resultado.getBoolean("activo");
            long tipoAnuncio = resultado.getLong("tipo_anuncio");
            String texto = resultado.getString("texto");
            String rutaImagen = resultado.getString("ruta_imagen");

            return new Anuncio(idAnuncioSeleccionado, fechaInicio, idPeriodoDeTiempo, idUsuario, activo, tipoAnuncio, texto, rutaImagen);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return null;
}
    
}
