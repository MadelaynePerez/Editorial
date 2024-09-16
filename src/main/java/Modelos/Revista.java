/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Revista {
     private long idRevista; // PRIMARY KEY
    private long idCategoria; // FOREIGN KEY a Categoria
    private String descripcion;
    private String autor;
    private java.sql.Date fechaDeCreacion;
    private double costoPorDia;
    private double precio;
    private String ruta;
    private boolean aceptarComentario;
    private boolean aceptarMeGusta;

    public long getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(long idRevista) {
        this.idRevista = idRevista;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isAceptarComentario() {
        return aceptarComentario;
    }

    public void setAceptarComentario(boolean aceptarComentario) {
        this.aceptarComentario = aceptarComentario;
    }

    public boolean isAceptarMeGusta() {
        return aceptarMeGusta;
    }

    public void setAceptarMeGusta(boolean aceptarMeGusta) {
        this.aceptarMeGusta = aceptarMeGusta;
    }

    public Revista(long idRevista, long idCategoria, String descripcion, String autor, Date fechaDeCreacion, double costoPorDia, double precio, String ruta, boolean aceptarComentario, boolean aceptarMeGusta) {
        this.idRevista = idRevista;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaDeCreacion = fechaDeCreacion;
        this.costoPorDia = costoPorDia;
        this.precio = precio;
        this.ruta = ruta;
        this.aceptarComentario = aceptarComentario;
        this.aceptarMeGusta = aceptarMeGusta;
    }
    
    
    
    
    
}
