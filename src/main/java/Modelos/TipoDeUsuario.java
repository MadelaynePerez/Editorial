/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class TipoDeUsuario {
     private long idTipoUsuario; // PRIMARY KEY
    private String tipoDeUsuario;

    public long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public TipoDeUsuario(long idTipoUsuario, String tipoDeUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoDeUsuario = tipoDeUsuario;
    }

}

