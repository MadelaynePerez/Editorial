/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class Comentario {
      private long idComentario; // PRIMARY KEY
    private String texto;
    private long idUsuario; // FOREIGN KEY a Usuario
    private long idRevista; // FOREIGN KEY a Revista
    private long fecha;

    public long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(long idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(long idRevista) {
        this.idRevista = idRevista;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public Comentario(long idComentario, String texto, long idUsuario, long idRevista, long fecha) {
        this.idComentario = idComentario;
        this.texto = texto;
        this.idUsuario = idUsuario;
        this.idRevista = idRevista;
        this.fecha = fecha;
    }

}
