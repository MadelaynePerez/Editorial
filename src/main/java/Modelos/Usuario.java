/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class Usuario {

    private String nombre;
    private Long idUsuario; // PRIMARY KEY
    private String contrasena;
    private String correoElectronico;
    private String hobbie;
    private String descripcion;
    private String temasDeInteres;
    private String gustos;
    private Long tipoUsuario; // FOREIGN KEY a TipoDeUsuario
    private String foto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemasDeInteres() {
        return temasDeInteres;
    }

    public void setTemasDeInteres(String temasDeInteres) {
        this.temasDeInteres = temasDeInteres;
    }

    public String getGustos() {
        return gustos;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public long getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Long tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario(Long idUsuario, String nombre, String contrasena, String correoElectronico, String hobbie, String descripcion, String temasDeInteres, String gustos, Long tipoUsuario, String foto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.hobbie = hobbie;
        this.descripcion = descripcion;
        this.temasDeInteres = temasDeInteres;
        this.gustos = gustos;
        this.tipoUsuario = tipoUsuario;
        this.foto = foto;
    }

}
