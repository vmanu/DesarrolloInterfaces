/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data_access_object.CarrouselDAO;
import modelo.Imagen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class Carrousel {
    
    private ArrayList <Imagen> imagenes;
    private int posicionActual;
    
    public Carrousel(){
        imagenes=new ArrayList();
        posicionActual=0;
    }

    public ArrayList <Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList <Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    
    public int getTamano(){
        return imagenes.size();
    }
    
    /**
     * Evalua si la imagen pasada ya existe en el Array y si existe, no lo agrega, además enviará un boolean false que notificará la no agregación.
     * En caso de agregarse (no existia), envia true para notificar que ha sido agregado
     * @param imagen
     * @return true|false dependiendo de si ha sido agregado el Objeto Imagen
     */
    public boolean agregarImagen(Imagen imagen){
        boolean sal=false;
        for (int i=0;i<imagenes.size()&&!sal;i++){
            if(imagenes.get(i).getRutaImagen().equals(imagen.getRutaImagen())){
                sal=true;
            }
        }
        if(!sal){
            setDimensionesImagen(imagen);
            imagenes.add(imagen);
        }
        return !sal;
    }
    
    public void quitarImagen(){
        imagenes.get(posicionActual).borradoImagenes();
        imagenes.remove(posicionActual);
        retrocederPosicion();
    }
    
    public Imagen getImagen(int pos){
        return imagenes.get(pos);
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public int getPosicionSiguiente(){
        return (posicionActual+1)%imagenes.size();
    }
    
    public int getDosPosicionesSiguientes(){
        return (getPosicionSiguiente()+1)%imagenes.size();
    }
    
    public int getPosicionAnterior(){
        int posTeorica=posicionActual-1;
        return posTeorica<0?(imagenes.size()-1):posTeorica;
    }
    
    public int getDosPosicionesAnteriores(){
        int posTeorica=getPosicionAnterior()-1;
        return posTeorica<0?(imagenes.size()-1):posTeorica;
    }
    
    public void avanzarPosicion(){
        posicionActual++;
        posicionActual%=imagenes.size();
    }
    
    public void retrocederPosicion(){
        posicionActual--;
        if(posicionActual<0){
            posicionActual=imagenes.size()-1;
        }
    }
    
    public ArrayList<Imagen> muestraCarrousel(){
        ArrayList<Imagen> muestra=new ArrayList();
        int pos[]=new int[5];
        pos[0]=getPosicionActual();
        pos[1]=getPosicionSiguiente();
        pos[2]=getPosicionAnterior();
        pos[3]=getDosPosicionesSiguientes();
        pos[4]=getDosPosicionesAnteriores();
        Imagen image=null;
        if(imagenes.size()<5){
            image=new Imagen("src\\main\\resources\\imagenes\\imagenNoDisponible.png");
            image.setDimensionImagen();
        }
        for (int i=0;i<5;i++){
            if(i<imagenes.size()){
                muestra.add(getImagen(pos[i]));
            }else{
                muestra.add(image);
            }
            
        }
        return muestra;
    }
    
    public void setDimensionesImagen(Imagen imagen){
        imagen.setDimensionImagen();
    }
    
    public ImageIcon getImagenDimensionada(String ruta){
        ImageIcon image=null;
        try {
            image=new ImageIcon(ImageIO.read(new File(ruta)));
        } catch (IOException ex) {
            Logger.getLogger("Vaya hostia nos hemo dao...").log(Level.SEVERE, null, ex);
        }
        return image;
    }
    
    public BufferedImage getImagenDimensionadaPrincipal(String ruta){
        BufferedImage im=null;
        try {
            im=ImageIO.read(new File(ruta));
        } catch (IOException ex) {
            Logger.getLogger("Vaya hostia nos hemo dao...").log(Level.SEVERE, null, ex);
        }
        return im;
    }
    
    public void guardarCarrousel(String ruta){
        CarrouselDAO guarda=new CarrouselDAO();
        guarda.guarda(imagenes, ruta);
    }
    
    public boolean cargarCarrousel(String ruta){
        CarrouselDAO carga=new CarrouselDAO();
        return (imagenes=carga.carga(ruta))!=null;
    }
}
