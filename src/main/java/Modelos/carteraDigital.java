/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class carteraDigital {
     private long idCartera; // PRIMARY KEY
    private long idUsuario; // FOREIGN KEY a Usuario
    private double saldo;

    public long getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(long idCartera) {
        this.idCartera = idCartera;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public carteraDigital(long idCartera, long idUsuario, double saldo) {
        this.idCartera = idCartera;
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }
    
    
}
