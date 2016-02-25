/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import static constantes.Constantes.*;
import control.ControlImagen;
import data_access_object.ImagenDAO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author Victor
 */
public class Imagen implements Serializable{
    private String rutaImagen;
    private String pathGrande;
    private String pathIcono;
    private String pathGrandeBlur;
    private String pathIconoBlur;
    private String pathGrandeWB;
    private String pathIconoWB;
    private int estado;//0=Normal;1=Blur;2=Black&White
    
    public Imagen(){
        estado=PINTA_NORMAL;
    }
    
    public Imagen(String pathImage) {
        this.rutaImagen = pathImage;
        pathGrande="imagenes\\Grandes\\Normal\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        pathIcono="imagenes\\Iconos\\Normal\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        pathGrandeBlur="imagenes\\Grandes\\Blur\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        pathIconoBlur="imagenes\\Iconos\\Blur\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        pathGrandeWB="imagenes\\Grandes\\BlackAndWhite\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
        pathIconoWB="imagenes\\Iconos\\BlackAndWhite\\"+pathImage.substring(pathImage.lastIndexOf("\\")+1);
    }
    
    public void setEstado(int estado){
        this.estado=estado;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getRutaImagenPrincipal() {
        return estado==PINTA_NORMAL?pathGrande:(estado==PINTA_BLUR?pathGrandeBlur:pathGrandeWB);
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getRutaImagenIcono() {
        return estado==PINTA_NORMAL?pathIcono:(estado==PINTA_BLUR?pathIconoBlur:pathIconoWB);
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public boolean compruebaSiExiste() {
        return new File(pathGrande).exists()&&new File(pathIcono).exists()&&new File(pathGrandeBlur).exists()&&new File(pathIconoBlur).exists()&&new File(pathGrandeWB).exists()&&new File(pathIconoWB).exists();
    }

    public String getPathGrande() {
        return pathGrande;
    }

    public String getPathIcono() {
        return pathIcono;
    }

    public String getPathGrandeBlur() {
        return pathGrandeBlur;
    }

    public String getPathIconoBlur() {
        return pathIconoBlur;
    }

    public String getPathGrandeWB() {
        return pathGrandeWB;
    }

    public String getPathIconoWB() {
        return pathIconoWB;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    public void setDimensionImagen(){
        int wIcon;
        int hIcon;
        int wMuestra;
        int hMuestra;
        try {
            BufferedImage im=ImageIO.read(new File(rutaImagen));
            int wOriginal=im.getWidth();
            int hOriginal=im.getHeight();
            if(wOriginal<hOriginal){
                wIcon=ICON_SIZE*wOriginal/hOriginal;
                hIcon=ICON_SIZE;
                wMuestra=MAIN_IMAGE_SIZE*wOriginal/hOriginal;
                hMuestra=MAIN_IMAGE_SIZE;
            }else{
                wIcon=ICON_SIZE;
                hIcon=ICON_SIZE*hOriginal/wOriginal;
                wMuestra=MAIN_IMAGE_SIZE;
                hMuestra=MAIN_IMAGE_SIZE*hOriginal/wOriginal;
            }
            ImagenDAO imIc=new ImagenDAO();
            imIc.guardarImagen(pathGrande, Scalr.resize(im, Scalr.Mode.AUTOMATIC, wMuestra, hMuestra, null));
            imIc.guardarImagen(pathIcono, Scalr.resize(im, Scalr.Mode.AUTOMATIC, wIcon, hIcon, null));
            /////////////////////////////////////////////////////////////////////////////////////////////////////
            imIc.guardarImagen(pathGrandeBlur, blurImagen(Scalr.resize(im, Scalr.Mode.AUTOMATIC, wMuestra, hMuestra, null)));
            imIc.guardarImagen(pathIconoBlur, blurImagen(Scalr.resize(im, Scalr.Mode.AUTOMATIC, wIcon, hIcon, null)));
            imIc.guardarImagen(pathGrandeWB, greyScaleImagen(Scalr.resize(im, Scalr.Mode.AUTOMATIC, wMuestra, hMuestra, null)));
            imIc.guardarImagen(pathIconoWB, greyScaleImagen(Scalr.resize(im, Scalr.Mode.AUTOMATIC, wIcon, hIcon, null)));
        } catch (IOException ex) {
            Logger.getLogger("Vaya hostia nos hemo dao...").log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage blurImagen(BufferedImage im) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = im;
            Kernel kernel = new Kernel(3, 3, new float[]{1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f});
            BufferedImageOp op = new ConvolveOp(kernel);
            bufferedImage = op.filter(op.filter(op.filter(op.filter(bufferedImage, null), null), null), null);
        } catch (Exception ex) {
            Logger.getLogger(ControlImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bufferedImage;
    }
    
    public BufferedImage greyScaleImagen(BufferedImage im) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = im;
            BufferedImageOp op =  new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            op =  op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            bufferedImage = op.filter(bufferedImage, null);
            //op.filter(op.filter(op.filter(bufferedImage, null), null), null)
        } catch (Exception ex) {
            Logger.getLogger(ControlImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bufferedImage;
    }
    
    public void setPathGrande(String pathGrande) {
        this.pathGrande = pathGrande;
    }

    public void setPathIcono(String pathIcono) {
        this.pathIcono = pathIcono;
    }

    public void setPathGrandeBlur(String pathGrandeBlur) {
        this.pathGrandeBlur = pathGrandeBlur;
    }

    public void setPathIconoBlur(String pathIconoBlur) {
        this.pathIconoBlur = pathIconoBlur;
    }

    public void setPathGrandeWB(String pathGrandeWB) {
        this.pathGrandeWB = pathGrandeWB;
    }

    public void setPathIconoWB(String pathIconoWB) {
        this.pathIconoWB = pathIconoWB;
    }
    
    public void borradoImagenes(){
        File borra=new File(pathGrande);
        borra.delete();
        borra=new File(pathIcono);
        borra.delete();
        borra=new File(pathGrandeBlur);
        borra.delete();
        borra=new File(pathIconoBlur);
        borra.delete();
        borra=new File(pathGrandeWB);
        borra.delete();
        borra=new File(pathIconoWB);
        borra.delete();
    }
}
