/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import javax.swing.Icon;
import modelo.Ficha;

/**
 *
 * @author dam2
 */
public class ControlFichas {
    private CarrouselFichas carrousel;
    
    public ControlFichas(){
        carrousel=new CarrouselFichas();
    }

    public int getTamanoCarrousel() {
        return carrousel.getTamanoCarrousel();
    }

    public void borraActual() {
        carrousel.borraActual();
    }

    public void siguienteFicha() {
        carrousel.siguienteFicha();
    }

    public void anteriorFicha() {
        carrousel.anteriorFicha();
    }

    public int getIndexFichaActual() {
        return carrousel.getIndexFichaActual();
    }

    public Icon getImagen(String pathImageMostrar) {
        return carrousel.getImagen(pathImageMostrar);
    }

    public ArrayList<Ficha> getCarrouselFichas() {
        return carrousel.getCarrouselFichas();
    }

    public void agregarFicha(String nombre, String marca, String tipo, int edad, double precio, String pathImage) {
        carrousel.agregarFicha(nombre,marca,tipo,edad,precio,pathImage);
    }

    public void guardarEstado() {
        carrousel.guardarEstado();
    }

    public void cargarEstado() {
        carrousel.cargarEstado();
    }

    public void modificaFicha(String nombre, String marca, String tipo, int edad, double precio, String pathImage) {
        carrousel.modificaFicha(nombre,marca,tipo,edad,precio,pathImage);
    }
}
