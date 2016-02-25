package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static constantes.Constantes.*;
import control.ControlImagen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import view.Vista;
import static utilidades.TesterUtilities.*;
import view.PanelImagen;

/**
 *
 * @author victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMenuArchivo {
    private FrameFixture frame;
    private ControlImagen control;
    
    public TestMenuArchivo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Vista c=new Vista();
        frame=new FrameFixture(c);
        control=c.getControlImagen();
        frame.show();        
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    @Test
    public void agregarImagen(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        agregarImagenPaso(frame,new File(FILE_STRING_IMG_1));
        assertEquals(control.getTamanoCarrousel(), 1);
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_2));
        assertEquals(control.getTamanoCarrousel(), 2);
        assertEquals(control.getImagenActual().getRutaImagen().substring(control.getImagenActual().getRutaImagen().indexOf("src\\")),FILE_STRING_IMG_1);
        assertEquals(control.getImagenActual().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_1, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getImagenSiguiente().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_2, OPTION_PATH_ICONO_NORMAL));
        //Comprobamos imagen principal en icono
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        //Comprobamos imagen icono derecho
        ref=referenciaIcono(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        //Comprobamos imagen icono izquierdo
        ref=referenciaIcono(FILE_STRING_NO_IMAGE);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        //Comprobamos imagen icono derecho extremo
        ref=referenciaIcono(FILE_STRING_NO_IMAGE);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        //Comprobamos imagen icono izquierdo
        ref=referenciaIcono(FILE_STRING_NO_IMAGE);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        //Comprobamos imagen principal
        ref=referenciaPrincipal(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        //borramos archivos residuales(Generados para las comprobaciones)
        String[] borra={FILE_STRING_NO_IMAGE+"icon.jpg",FILE_STRING_IMG_1+"icon.jpg",FILE_STRING_IMG_2+"icon.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void borrarImagen(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        agregarImagenPaso(frame,new File(FILE_STRING_IMG_1));
        assertEquals(control.getTamanoCarrousel(), 1);
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_2));
        assertEquals(control.getTamanoCarrousel(), 2);
        agregarImagenPaso(frame,new File(FILE_STRING_IMG_3));
        assertEquals(control.getTamanoCarrousel(), 3);
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_4));
        assertEquals(control.getTamanoCarrousel(), 4);
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_5));
        assertEquals(control.getTamanoCarrousel(), 5);
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_2));
        assertEquals(control.getTamanoCarrousel(), 5);
        assertEquals(control.getImagenActual().getRutaImagen().substring(control.getImagenActual().getRutaImagen().indexOf("src\\")),FILE_STRING_IMG_1);
        assertEquals(control.getImagenActual().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_1, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getImagenSiguiente().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_2, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getDosImagenesSiguientes().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_3, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getImagenAnterior().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_5, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getDosImagenesAnteriores().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_4, OPTION_PATH_ICONO_NORMAL));
        
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_5);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_3);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_4);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipal(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        //ELIMINAMOS IMAGEN
        eliminarImagen(frame);
        assertEquals(control.getTamanoCarrousel(), 4);
        assertEquals(control.getImagenActual().getRutaImagen().substring(control.getImagenActual().getRutaImagen().indexOf("src\\")),FILE_STRING_IMG_5);
        assertEquals(control.getImagenActual().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_5, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getImagenSiguiente().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_2, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getDosImagenesSiguientes().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_3, OPTION_PATH_ICONO_NORMAL));
        assertEquals(control.getImagenAnterior().getRutaImagenIcono(),generatePath(FILE_STRING_IMG_4, OPTION_PATH_ICONO_NORMAL));
        ref=referenciaIcono(FILE_STRING_IMG_5);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_2);
        icon=(ImageIcon)frame.label(LABEL_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_4);
        icon=(ImageIcon)frame.label(LABEL_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_3);
        icon=(ImageIcon)frame.label(LABEL_EXT_DERECHA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_NO_IMAGE);
        icon=(ImageIcon)frame.label(LABEL_EXT_IZQUIERDA).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaPrincipal(FILE_STRING_IMG_5);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_NO_IMAGE+"icono.jpg",FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_2+"icono.jpg",FILE_STRING_IMG_3+"icono.jpg",FILE_STRING_IMG_4+"icono.jpg",FILE_STRING_IMG_5+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg",FILE_STRING_IMG_5+"muestra.jpg"};
        borraArchivosResiduales(borra);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMenuArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void menuGuardar(){
        //Nos aseguramos que el archivo que vamos a generar no existe, para comprobar su correcta creación posteriormente
        File comprueba=new File(FILE_STRING_SAVED);
        if(comprueba.exists()){
            comprueba.delete();
        }
        agregarImagenPaso(frame,new File(FILE_STRING_IMG_1));
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_2));
        agregarImagenPaso(frame,new File(FILE_STRING_IMG_3));
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_4));
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_5));
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_6));
        agregarImagenPaso(frame, new File(FILE_STRING_IMG_7));
        assertEquals(control.getTamanoCarrousel(), 7);
        JMenuItemFixture archivo = frame.menuItem(MENU_ARCHIVO);
        archivo.click();
        JMenuItemFixture guardar = frame.menuItem(MENU_GUARDAR);
        guardar.click();
        JFileChooserFixture selector = frame.fileChooser(FILECHOOSER);
        selector.setCurrentDirectory(new File(FILE_STRING_SAVED));
        selector.selectFile(new File(FILE_STRING_SAVED));
        selector.approve();
        assertTrue(comprueba.exists());
    }
    
    @Test
    public void menuLoad(){
        ImageIcon ref=null;
        ImageIcon icon=null;
        BufferedImage muestra=null;
        JMenuItemFixture archivo = frame.menuItem(MENU_ARCHIVO);
        archivo.click();
        JMenuItemFixture cargar = frame.menuItem(MENU_CARGAR);
        cargar.click();
        JFileChooserFixture selector = frame.fileChooser(FILECHOOSER);
        selector.setCurrentDirectory(new File(FILE_STRING_SAVED));
        selector.selectFile(new File(FILE_STRING_SAVED));
        selector.approve();
        ref=referenciaIcono(FILE_STRING_IMG_1);
        icon=(ImageIcon)frame.label(LABEL_CENTRO).target.getIcon();
        assertTrue(compareImages((BufferedImage)(icon.getImage()),(BufferedImage)ref.getImage()));
        ref=referenciaIcono(FILE_STRING_IMG_2);
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
        ref=referenciaPrincipal(FILE_STRING_IMG_1);
        muestra=((PanelImagen)frame.panel(PANEL_MOSTRAR).target).getImagen();
        assertTrue(compareImages(muestra,(BufferedImage)ref.getImage()));
        String[] borra={FILE_STRING_IMG_1+"icono.jpg",FILE_STRING_IMG_2+"icono.jpg",FILE_STRING_IMG_3+"icono.jpg",FILE_STRING_IMG_6+"icono.jpg",FILE_STRING_IMG_7+"icono.jpg",FILE_STRING_IMG_1+"muestra.jpg"};
        borraArchivosResiduales(borra);
    }
}
