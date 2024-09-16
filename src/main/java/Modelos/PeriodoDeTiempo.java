/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class PeriodoDeTiempo {
     private long idPeriodoDeTiempo; // PRIMARY KEY
    private long periodoDisponible;
    private String tipo;

    public long getIdPeriodoDeTiempo() {
        return idPeriodoDeTiempo;
    }

    public void setIdPeriodoDeTiempo(long idPeriodoDeTiempo) {
        this.idPeriodoDeTiempo = idPeriodoDeTiempo;
    }

    public long getPeriodoDisponible() {
        return periodoDisponible;
    }

    public void setPeriodoDisponible(long periodoDisponible) {
        this.periodoDisponible = periodoDisponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PeriodoDeTiempo(long idPeriodoDeTiempo, long periodoDisponible, String tipo) {
        this.idPeriodoDeTiempo = idPeriodoDeTiempo;
        this.periodoDisponible = periodoDisponible;
        this.tipo = tipo;
    }

}
