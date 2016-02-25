/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Imagen;
import java.awt.image.BufferedImage; 
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class ControlImagen {
    private Carrousel carrousel;
    
    public ControlImagen(){
        carrousel=new Carrousel();
    }
    
    public boolean agregarImagen(Imagen imagen){
        return carrousel.agregarImagen(imagen);
    }
    
    public void quitarImagen(){
        carrousel.quitarImagen();
    }
    
    public Imagen getImagenActual(){
        return carrousel.getImagen(carrousel.getPosicionActual());
    }
    
    public Imagen getImagenSiguiente(){
        return carrousel.getImagen(carrousel.getPosicionSiguiente());
    }
    
    public Imagen getDosImagenesSiguientes(){
        return carrousel.getImagen(carrousel.getDosPosicionesSiguientes());
    }
    
    public Imagen getImagenAnterior(){
        return carrousel.getImagen(carrousel.getPosicionAnterior());
    }
    
    public Imagen getDosImagenesAnteriores(){
        return carrousel.getImagen(carrousel.getDosPosicionesAnteriores());
    }
    
    public void avanzarPosicion(){
        carrousel.avanzarPosicion();
    }
    
    public void retrocederPosicion(){
        carrousel.retrocederPosicion();
    }
    
    public int getTamanoCarrousel(){
        return carrousel.getTamano();
    }
    
    public ArrayList<Imagen> muestraCarrousel(){
        return carrousel.muestraCarrousel();
    }
    
    public ImageIcon getImagenDimensionada(String ruta){
        return carrousel.getImagenDimensionada(ruta);
    }
    
    public BufferedImage getImagenDimensionadaPrincipal(String ruta){
        return carrousel.getImagenDimensionadaPrincipal(ruta);
    }
    
    public void guardarCarrousel(String ruta){
        carrousel.guardarCarrousel(ruta);
    }
    
    public boolean cargarCarrousel(String ruta){
        return carrousel.cargarCarrousel(ruta);
    }
}
