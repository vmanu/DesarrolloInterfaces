/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static constantes.Constantes.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static utilidades.TesterUtilities.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import view.PanelImagen;
import view.Vista;

/**
 *
 * @author Victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopUpImagenes {
    private FrameFixture frame;
    
    public TestPopUpImagenes() {
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
        JPanelFixture panelMuestra = frame.panel(PANEL_MOSTRAR);
        panelMuestra.rightClick();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    @Test
    public void ponerBorrosoPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture blur = frame.menuItem(PMENU_BORROSO);
        blur.click();
        ref=referenciaIconoBlur(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalBlur(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void ponerGrisPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture gris = frame.menuItem(PMENU_BLANCO_Y_NEGRO);
        gris.click();
        ref=referenciaIconoGris(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalGris(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void ponerANormalPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture gris = frame.menuItem(PMENU_BLANCO_Y_NEGRO);
        gris.click();
        ref=referenciaIconoGris(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalGris(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        JPanelFixture panelMuestra = frame.panel(PANEL_MOSTRAR);
        panelMuestra.rightClick();
        JMenuItemFixture normal = frame.menuItem(PMENU_NORMAL);
        normal.click();
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipal(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void ponerLineaAIPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture linea = frame.menuItem(PMENU_PINTAR_LINEA);
        JMenuItemFixture lineaAI = frame.menuItem(PMENU_PINTAR_LINEA_DESDE_ARRIBA_IZQUIERDA);
        linea.click();
        lineaAI.click();
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalLinaAI(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void ponerLineaADPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture linea = frame.menuItem(PMENU_PINTAR_LINEA);
        JMenuItemFixture lineaAD = frame.menuItem(PMENU_PINTAR_LINEA_DESDE_ARRIBA_DERECHA);
        linea.click();
        lineaAD.click();
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalLinaAD(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void ponerLineaCPopup(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture linea = frame.menuItem(PMENU_PINTAR_LINEA);
        JMenuItemFixture lineaC = frame.menuItem(PMENU_PINTAR_LINEA_CRUZ);
        linea.click();
        lineaC.click();
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipalLinaC(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}