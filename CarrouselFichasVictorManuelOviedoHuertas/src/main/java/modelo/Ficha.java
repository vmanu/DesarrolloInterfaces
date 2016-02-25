/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dao.ImagenDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import static constantes.Constantes.*;

/**
 *
 * @author dam2
 */
public class Ficha {
    private String nombre;
    private String marca;
    private String tipo;
    private int edad;
    private double precio;
    private String pathImage;
    private String pathImageMostrar;

    public Ficha(){
        
    }
    
    public Ficha(String nombre, String marca, String tipo, int edad, double precio, String pathImage) {
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.edad = edad;
        this.precio = precio;
        this.pathImage = pathImage;
        pathImageMostrar="imagenes/"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        reescaladoImagen();
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getPathImageMostrar() {
        return pathImageMostrar;
    }
    
    /*public void setPathImageMostrar(String pathImageMostrar){
        this.pathImageMostrar=pathImageMostrar;
    }*/
    
    public String getPathImage(){
        return pathImage;
    }
    
    public void setPathImage(String pathImage){
        if(pathImageMostrar!=null&&!pathImageMostrar.isEmpty()){
            new File(pathImageMostrar).delete();
        }
        this.pathImage=pathImage;
        pathImageMostrar="imagenes/"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        reescaladoImagen();
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void reescaladoImagen(){
        int wImagen;
        int hImagen;
        try {
            BufferedImage im=ImageIO.read(new File(pathImage));
            int wOriginal=im.getWidth();
            int hOriginal=im.getHeight();
            if(wOriginal<hOriginal){
                wImagen=ALTURA_IMAGEN*wOriginal/hOriginal;
                hImagen=ALTURA_IMAGEN;
            }else{
                wImagen=ANCHO_IMAGEN;
                hImagen=ANCHO_IMAGEN*hOriginal/wOriginal;
            }
            new ImagenDAO().guardarImagen(pathImageMostrar, Scalr.resize(im, Scalr.Mode.AUTOMATIC, wImagen, hImagen, null));
        } catch (IOException ex) {
            
        }
    }
}
