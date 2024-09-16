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
public class Anuncio {
      private long idAnuncio; // PRIMARY KEY
    private java.sql.Date fechaInicio;
    private long idPeriodoDeTiempo; // FOREIGN KEY a PeriodoDeTiempo
    private long idUsuario; // FOREIGN KEY a Usuario
    private boolean activo;
    private long tipoAnuncio; // FOREIGN KEY a TipoDeAnuncio
    private String texto;
    private String rutaImagen;

    public long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public long getIdPeriodoDeTiempo() {
        return idPeriodoDeTiempo;
    }

    public void setIdPeriodoDeTiempo(long idPeriodoDeTiempo) {
        this.idPeriodoDeTiempo = idPeriodoDeTiempo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(long tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Anuncio(long idAnuncio, Date fechaInicio, long idPeriodoDeTiempo, long idUsuario, boolean activo, long tipoAnuncio, String texto, String rutaImagen) {
        this.idAnuncio = idAnuncio;
        this.fechaInicio = fechaInicio;
        this.idPeriodoDeTiempo = idPeriodoDeTiempo;
        this.idUsuario = idUsuario;
        this.activo = activo;
        this.tipoAnuncio = tipoAnuncio;
        this.texto = texto;
        this.rutaImagen = rutaImagen;
    }
    
    
    
}
