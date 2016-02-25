/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static constantes.Constantes.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static utilidades.TesterUtilities.*;
import view.PanelImagen;
import view.Vista;



/**
 *
 * @author Victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConservacionEstado {
    private FrameFixture frame;
    
    public TestConservacionEstado() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        frame=new FrameFixture(new Vista());
        frame.show();
        JMenuItemFixture archivo = frame.menuItem(MENU_ARCHIVO);
        archivo.click();
        JMenuItemFixture cargar = frame.menuItem(MENU_CARGAR);
        cargar.click();
        JFileChooserFixture selector = frame.fileChooser(FILECHOOSER);
        selector.setCurrentDirectory(new File(FILE_STRING_SAVED));
        selector.selectFile(new File(FILE_STRING_SAVED));
        selector.approve();
        JMenuItemFixture imagenMenu = frame.menuItem(MENU_IMAGEN);
        imagenMenu.click();
        JMenuItemFixture blur=frame.menuItem(MENU_BORROSO);
        blur.click();
        JButtonFixture av=frame.button(BOTON_DER);
        av.click();
        imagenMenu.click();
        JMenuItemFixture gris=frame.menuItem(MENU_BLANCO_Y_NEGRO);
        gris.click();
        av.click();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    @Test
    public void compruebaEstado() {
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        //COMPROBAMOS ESTADO INICIAL CONSERVANDO EL ESTADO EN LOS ICONOS
        ref=referenciaIcono(FILE_STRING_IMG_3);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_4);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIconoGris(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_5);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIconoBlur(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipal(FILE_STRING_IMG_3);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_2+"icono.jpg",FILE_STRING_IMG_3+"icono.jpg",FILE_STRING_IMG_4+"icono.jpg",FILE_STRING_IMG_5+"icono.jpg",FILE_STRING_IMG_3+"muestra.jpg"};
        borraArchivosResiduales(borra);
        //COMPROBAMOS QUE EL GREYSCALE SE HA CONSERVADO
        JButtonFixture retr=frame.button(BOTON_IZQDA);
        retr.click();
        ref=referenciaIconoGris(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_3);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIconoBlur(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_4);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_7);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalGris(FILE_STRING_IMG_2);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra2={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_2+"icono.jpg",FILE_STRING_IMG_3+"icono.jpg",FILE_STRING_IMG_4+"icono.jpg",FILE_STRING_IMG_7+"icono.jpg",FILE_STRING_IMG_2+"muestra.jpg"};
        borraArchivosResiduales(borra2);
        retr.click();
        ref=referenciaIconoBlur(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIconoGris(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_7);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_3);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_6);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalBlur(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra3={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_2+"icono.jpg",FILE_STRING_IMG_3+"icono.jpg",FILE_STRING_IMG_6+"icono.jpg",FILE_STRING_IMG_7+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra3);
    }
}
