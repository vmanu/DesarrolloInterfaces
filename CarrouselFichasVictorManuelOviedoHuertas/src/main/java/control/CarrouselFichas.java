/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Carrousel_DAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Ficha;

/**
 *
 * @author dam2
 */
public class CarrouselFichas {
    private ArrayList<Ficha> fichas;
    private int index;
    
    public CarrouselFichas(){
        fichas=new ArrayList();
        index=0;
    }
    
    public int getTamanoCarrousel() {
        return fichas.size();
    }

    public void borraActual() {
        new File(fichas.get(index).getPathImageMostrar()).delete();
        fichas.remove(index);
        anteriorFicha();
    }

    public void siguienteFicha() {
        index++;
        index%=fichas.size();
    }

    public void anteriorFicha() {
        index--;
        if(index<0){
            index=fichas.size()-1;
        }
    }

    public int getIndexFichaActual() {
        return index;
    }

    public Icon getImagen(String pathImageMostrar) {
        ImageIcon image=null;
        try {
            image=new ImageIcon(ImageIO.read(new File(pathImageMostrar)));
        } catch (IOException ex) {
            
        }
        return image;
    }

    public ArrayList<Ficha> getCarrouselFichas() {
        return fichas;
    }

    public void agregarFicha(String nombre, String marca, String tipo, int edad, double precio, String pathImage) {
        fichas.add(new Ficha(nombre,marca,tipo,edad,precio,pathImage));
    }

    public void cargarEstado() {
        fichas=new Carrousel_DAO().carga();
    }

    public void guardarEstado() {
        new Carrousel_DAO().guarda(fichas);
    }

    void modificaFicha(String nombre, String marca, String tipo, int edad, double precio, String pathImage) {
        if(!nombre.equals(fichas.get(index).getNombre())){
            fichas.get(index).setNombre(nombre);
        }
        if(!marca.equals(fichas.get(index).getMarca())){
            fichas.get(index).setMarca(marca);
        }
        if(!tipo.equals(fichas.get(index).getTipo())){
            fichas.get(index).setTipo(tipo);
        }
        if(edad!=fichas.get(index).getEdad()){
            fichas.get(index).setEdad(edad);
        }
        if(precio!=fichas.get(index).getPrecio()){
            fichas.get(index).setPrecio(precio);
        }
        if(!pathImage.equals(fichas.get(index).getPathImage())){
            fichas.get(index).setPathImage(pathImage);
        }
    }
    
}
