/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author DELL
 */
public class Costo {
      private long idCosto; // PRIMARY KEY
    private double costoPorRevista;

    public long getIdCosto() {
        return idCosto;
    }

    public void setIdCosto(long idCosto) {
        this.idCosto = idCosto;
    }

    public double getCostoPorRevista() {
        return costoPorRevista;
    }

    public void setCostoPorRevista(double costoPorRevista) {
        this.costoPorRevista = costoPorRevista;
    }

    public Costo(long idCosto, double costoPorRevista) {
        this.idCosto = idCosto;
        this.costoPorRevista = costoPorRevista;
    }
    
    
    
}
