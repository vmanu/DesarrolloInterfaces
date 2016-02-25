/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Victor
 */
public class ImagenDAO {
    
    public void guardarImagen(String ruta,BufferedImage imagen){
        try {
           ImageIO.write(imagen, "jpg", new File(ruta));
        } catch (IOException e) {
           System.out.println("Error de escritura, puede que exista el archivo");
        }
    }
    
    public BufferedImage cargarImagen(String ruta,BufferedImage imagen){
        BufferedImage im=null;
        try {
           ImageIO.read(new File(ruta));
        } catch (IOException e) {
           System.out.println("Error de lectura");
        }
        return im;
    }
}
