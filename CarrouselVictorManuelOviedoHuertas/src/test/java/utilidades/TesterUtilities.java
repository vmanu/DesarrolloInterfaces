package utilidades;

import static constantes.Constantes.*;
import control.ControlImagen;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.fest.swing.fixture.*;
import org.imgscalr.Scalr;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor
 */
public class TesterUtilities {

    public static String generatePath(String pathImage, int opcion) {
        String cadena = "";
        switch (opcion) {
            case OPTION_PATH_GRANDE_NORMAL:
                cadena = "imagenes\\Grandes\\Normal\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
            case OPTION_PATH_ICONO_NORMAL:
                cadena = "imagenes\\Iconos\\Normal\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
            case OPTION_PATH_GRANDE_BLUR:
                cadena = "imagenes\\Grandes\\Blur\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
            case OPTION_PATH_ICONO_BLUR:
                cadena = "imagenes\\Iconos\\Blur\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
            case OPTION_PATH_GRANDE_BW:
                cadena = "imagenes\\Grandes\\BlackAndWhite\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
            case OPTION_PATH_ICONO_BW:
                cadena = "imagenes\\Iconos\\BlackAndWhite\\" + pathImage.substring(pathImage.lastIndexOf("\\") + 1);
                break;
        }
        return cadena;
    }

    public static void agregarImagenPaso(FrameFixture frame, File ruta) {
        JMenuItemFixture menu = frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture agregar = frame.menuItem(MENU_AGREGAR);
        menu.click();
        agregar.click();
        JFileChooserFixture selector = frame.fileChooser(FILECHOOSER);
        selector.setCurrentDirectory(ruta);
        selector.selectFile(ruta);
        selector.approve();
    }

    public static void eliminarImagen(FrameFixture frame) {
        JMenuItemFixture menu = frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture agregar = frame.menuItem(MENU_QUITAR);
        menu.click();
        agregar.click();
    }

    public static boolean compareImages(BufferedImage im1, BufferedImage im2) {
        if (im1.getWidth() == im2.getWidth() && im1.getHeight() == im2.getHeight()) {
            int ancho = im1.getWidth();
            int alto = im1.getHeight();
            for (int y = 0; y < alto; y++) {
                for (int x = 0; x < ancho; x++) {
                    if (im1.getRGB(x, y) != im2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    public static BufferedImage convertirEnPricipal(File path) {
        int wMuestra = 0;
        int hMuestra = 0;
        BufferedImage ref = null;
        try {
            ref = ImageIO.read(path);
            int wOriginal = ref.getWidth();
            int hOriginal = ref.getHeight();
            if (wOriginal < hOriginal) {
                wMuestra = MAIN_IMAGE_SIZE * wOriginal / hOriginal;
                hMuestra = MAIN_IMAGE_SIZE;
            } else {
                wMuestra = MAIN_IMAGE_SIZE;
                hMuestra = MAIN_IMAGE_SIZE * hOriginal / wOriginal;
            }
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Scalr.resize(ref, Scalr.Mode.AUTOMATIC, wMuestra, hMuestra, null);
    }

    public static BufferedImage convertirEnIcon(File path) {
        int wIcon = 0;
        int hIcon = 0;
        BufferedImage ref = null;
        try {
            ref = ImageIO.read(path);
            int wOriginal = ref.getWidth();
            int hOriginal = ref.getHeight();
            if (wOriginal < hOriginal) {
                wIcon = ICON_SIZE * wOriginal / hOriginal;
                hIcon = ICON_SIZE;
            } else {
                wIcon = ICON_SIZE;
                hIcon = ICON_SIZE * hOriginal / wOriginal;
            }

        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Scalr.resize(ref, Scalr.Mode.AUTOMATIC, wIcon, hIcon, null);
    }

    public static ImageIcon referenciaIcono(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(convertirEnIcon(new File(file)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"icono.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"icono.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipal(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(convertirEnPricipal(new File(file)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"muestra.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaIconoBlur(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(ponerImagenBorrosa(convertirEnIcon(new File(file))));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"icono.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"icono.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipalBlur(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(ponerImagenBorrosa(convertirEnPricipal(new File(file))));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"muestra.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaIconoGris(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(ponerImagenGris(convertirEnIcon(new File(file))));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"icono.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"icono.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipalGris(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(ponerImagenGris(convertirEnPricipal(new File(file))));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ImageIO.read( new File(file+"muestra.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipalLinaAI(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(convertirEnPricipal(new File(file)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ponerImagenLineaAI(ImageIO.read( new File(file+"muestra.jpg"))));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipalLinaAD(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(convertirEnPricipal(new File(file)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ponerImagenLineaAD(ImageIO.read( new File(file+"muestra.jpg"))));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static ImageIcon referenciaPrincipalLinaC(String file){
        ImageIcon ref=null;
        try {
            ref = new ImageIcon(convertirEnPricipal(new File(file)));
            ImageIO.write((BufferedImage)ref.getImage(), "jpg", new File(file+"muestra.jpg"));
            ref = new ImageIcon(ponerImagenLineaC(ImageIO.read( new File(file+"muestra.jpg"))));
        } catch (IOException ex) {
            Logger.getLogger(TesterUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ref;
    }
    
    public static void borraArchivosResiduales(String[] files){
        for (String file : files) {
            File borra=new File(file);
            borra.delete();
        }
    }
    
    public static BufferedImage ponerImagenBorrosa(BufferedImage im) {
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
    
    public static BufferedImage ponerImagenGris(BufferedImage im) {
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

    public static BufferedImage ponerImagenLineaAI(BufferedImage im) {
        Graphics2D g = im.createGraphics();
        g.setColor(Color.red);
        g.drawLine(0, 0, im.getWidth(), im.getHeight());
        return im;
    }

    public static BufferedImage ponerImagenLineaAD(BufferedImage im){
        
        Graphics2D g = im.createGraphics();
        g.setColor(Color.red);
        g.drawLine(im.getWidth(), 0, 0, im.getHeight());
        
        return im;
    }

    public static BufferedImage ponerImagenLineaC(BufferedImage im) {
        Graphics2D g = im.createGraphics();
        g.setColor(Color.red);
        g.drawLine(0, 0, im.getWidth(), im.getHeight());
        g.drawLine(im.getWidth(), 0, 0, im.getHeight());
        return im;
    }
}
