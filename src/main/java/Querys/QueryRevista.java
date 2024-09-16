/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;

import Modelos.Coneccion;
import Modelos.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QueryRevista implements IBaseCrud<Revista>{
    @Override
public boolean crear(Revista entidad) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "INSERT INTO revista (id_categoria, descripcion, autor, fecha_de_creacion, costo_por_dia, precio, ruta, aceptar_comentario, aceptar_me_gusta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1, entidad.getIdCategoria());
        pstmt.setString(2, entidad.getDescripcion());
        pstmt.setString(3, entidad.getAutor());
        pstmt.setDate(4, entidad.getFechaDeCreacion());
        pstmt.setDouble(5, entidad.getCostoPorDia());
        pstmt.setDouble(6, entidad.getPrecio());
        pstmt.setString(7, entidad.getRuta());
        pstmt.setBoolean(8, entidad.isAceptarComentario());
        pstmt.setBoolean(9, entidad.isAceptarMeGusta());

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
public Revista eliminar(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    Revista revistaAntesDeEliminar = null;

    try {
        connection = Coneccion.getConnection();

        // Consultar la revista antes de eliminar
        revistaAntesDeEliminar = encontrarPorId(id);

        String sql = "DELETE FROM revista WHERE id_revista = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        int filasEliminadas = pstmt.executeUpdate();
        return filasEliminadas > 0 ? revistaAntesDeEliminar : null;

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
public boolean actualizar(Revista entidadActualizar) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "UPDATE revista SET id_categoria = ?, descripcion = ?, autor = ?, fecha_de_creacion = ?, costo_por_dia = ?, precio = ?, ruta = ?, aceptar_comentario = ?, aceptar_me_gusta = ? WHERE id_revista = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1, entidadActualizar.getIdCategoria());
        pstmt.setString(2, entidadActualizar.getDescripcion());
        pstmt.setString(3, entidadActualizar.getAutor());
        pstmt.setDate(4, entidadActualizar.getFechaDeCreacion());
        pstmt.setDouble(5, entidadActualizar.getCostoPorDia());
        pstmt.setDouble(6, entidadActualizar.getPrecio());
        pstmt.setString(7, entidadActualizar.getRuta());
        pstmt.setBoolean(8, entidadActualizar.isAceptarComentario());
        pstmt.setBoolean(9, entidadActualizar.isAceptarMeGusta());
        pstmt.setLong(10, entidadActualizar.getIdRevista());

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
public ArrayList<Revista> listar() {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ArrayList<Revista> revistas = new ArrayList<>();

    try {
        connection = Coneccion.getConnection();
        String sql = "SELECT id_revista, id_categoria, descripcion, autor, fecha_de_creacion, costo_por_dia, precio, ruta, aceptar_comentario, aceptar_me_gusta FROM revista";
        pstmt = connection.prepareStatement(sql);

        ResultSet resultado = pstmt.executeQuery();

        while (resultado.next()) {
            Long idRevista = resultado.getLong("id_revista");
            Long idCategoria = resultado.getLong("id_categoria");
            String descripcion = resultado.getString("descripcion");
            String autor = resultado.getString("autor");
            java.sql.Date fechaDeCreacion = resultado.getDate("fecha_de_creacion");
            double costoPorDia = resultado.getDouble("costo_por_dia");
            double precio = resultado.getDouble("precio");
            String ruta = resultado.getString("ruta");
            boolean aceptarComentario = resultado.getBoolean("aceptar_comentario");
            boolean aceptarMeGusta = resultado.getBoolean("aceptar_me_gusta");

            Revista revista = new Revista(idRevista, idCategoria, descripcion, autor, fechaDeCreacion, costoPorDia, precio, ruta, aceptarComentario, aceptarMeGusta);
            revistas.add(revista);
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

    return revistas;
}
@Override
public Revista encontrarPorId(Long id) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        connection = Coneccion.getConnection();
        String sql = "SELECT id_revista, id_categoria, descripcion, autor, fecha_de_creacion, costo_por_dia, precio, ruta, aceptar_comentario, aceptar_me_gusta FROM revista WHERE id_revista = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet resultado = pstmt.executeQuery();
        if (resultado.next()) {
            Long idRevista = resultado.getLong("id_revista");
            Long idCategoria = resultado.getLong("id_categoria");
            String descripcion = resultado.getString("descripcion");
            String autor = resultado.getString("autor");
            java.sql.Date fechaDeCreacion = resultado.getDate("fecha_de_creacion");
            double costoPorDia = resultado.getDouble("costo_por_dia");
            double precio = resultado.getDouble("precio");
            String ruta = resultado.getString("ruta");
            boolean aceptarComentario = resultado.getBoolean("aceptar_comentario");
            boolean aceptarMeGusta = resultado.getBoolean("aceptar_me_gusta");

            Revista revista = new Revista(idRevista, idCategoria, descripcion, autor, fechaDeCreacion, costoPorDia, precio, ruta, aceptarComentario, aceptarMeGusta);
            return revista;
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
public Revista encontrarPorAutor(String autor) {
    Connection connection = null;
    PreparedStatement pstmt = null;

    try {
        // Establecer conexión
        connection = Coneccion.getConnection();

        // Crear la sentencia SQL para encontrar una revista por autor
        String sql = "SELECT id_revista, id_categoria, descripcion, autor, fecha_de_creacion, costo_por_dia, precio, ruta, aceptar_comentario, aceptar_me_gusta FROM revista WHERE autor = ?";
        
        // Preparar el PreparedStatement
        pstmt = connection.prepareStatement(sql);
        
        // Establecer el valor del autor a buscar
        pstmt.setString(1, autor);
        
        // Ejecutar la consulta
        ResultSet resultado = pstmt.executeQuery();
        
        // Verificar si existe un resultado
        if (resultado.next()) {
            long idRevista = resultado.getLong("id_revista");
            long idCategoria = resultado.getLong("id_categoria");
            String descripcion = resultado.getString("descripcion");
            String autorResultado = resultado.getString("autor");
            java.sql.Date fechaDeCreacion = resultado.getDate("fecha_de_creacion");
            double costoPorDia = resultado.getDouble("costo_por_dia");
            double precio = resultado.getDouble("precio");
            String ruta = resultado.getString("ruta");
            boolean aceptarComentario = resultado.getBoolean("aceptar_comentario");
            boolean aceptarMeGusta = resultado.getBoolean("aceptar_me_gusta");
            
            // Crear el objeto Revista y retornarlo
            Revista revista = new Revista(idRevista, idCategoria, descripcion, autorResultado, fechaDeCreacion, costoPorDia, precio, ruta, aceptarComentario, aceptarMeGusta);
            return revista;
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
