/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author oscar
 */
public class Coche {
    
    private String marca;
    private String modelo;
    private int numeroAsientos;
    private double precio;

    public Coche() {
    }

    public Coche(String marca, String modelo, int numeroAsientos, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroAsientos = numeroAsientos;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    


}
