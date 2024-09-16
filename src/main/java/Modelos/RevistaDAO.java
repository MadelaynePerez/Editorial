/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// src/main/java/tu_paquete/RevistaDAO.java
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevistaDAO {

    public Revista encontrarPorAutor(String autor) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultado = null;
        Revista revista = null;

        try {
            // Establecer conexión
            connection = Coneccion.getConnection();

            // Crear la sentencia SQL para encontrar una revista por autor
            String sql = "SELECT id_revista, id_categoria, descripcion, autor, fecha_de_creacion, costo_por_dia, precio, ruta, aceptar_comentario, aceptar_me_gusta FROM revista WHERE autor = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, autor);

            // Ejecutar la consulta
            resultado = pstmt.executeQuery();

            if (resultado.next()) {
                long idRevista = resultado.getLong("id_revista");
                long idCategoria = resultado.getLong("id_categoria");
                String descripcion = resultado.getString("descripcion");
                String autorRevista = resultado.getString("autor");
                java.sql.Date fechaDeCreacion = resultado.getDate("fecha_de_creacion");
                double costoPorDia = resultado.getDouble("costo_por_dia");
                double precio = resultado.getDouble("precio");
                String ruta = resultado.getString("ruta");
                boolean aceptarComentario = resultado.getBoolean("aceptar_comentario");
                boolean aceptarMeGusta = resultado.getBoolean("aceptar_me_gusta");

                // Crear el objeto Revista y retornarlo
                revista = new Revista(idRevista, idCategoria, descripcion, autorRevista, fechaDeCreacion, costoPorDia, precio, ruta, aceptarComentario, aceptarMeGusta);
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

        return revista;
    }
}
