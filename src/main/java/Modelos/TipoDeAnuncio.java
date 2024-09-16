/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class TipoDeAnuncio {
     private long idTipoAnuncio; // PRIMARY KEY
    private String tipoAnuncio;
    private double precio;

    public long getIdTipoAnuncio() {
        return idTipoAnuncio;
    }

    public void setIdTipoAnuncio(long idTipoAnuncio) {
        this.idTipoAnuncio = idTipoAnuncio;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoDeAnuncio(long idTipoAnuncio, String tipoAnuncio, double precio) {
        this.idTipoAnuncio = idTipoAnuncio;
        this.tipoAnuncio = tipoAnuncio;
        this.precio = precio;
    }
    
}
