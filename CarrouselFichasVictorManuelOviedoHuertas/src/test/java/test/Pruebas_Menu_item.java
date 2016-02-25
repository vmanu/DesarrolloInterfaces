package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static constantes.Constantes.*;
import javax.swing.JTextField;
import org.fest.swing.fixture.JPanelFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.fest.swing.query.ComponentVisibleQuery;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import utilidades.Utilidades;
import view.Vista;
import static constantes.ComboItems.*;
import control.ControlFichas;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Pruebas_Menu_item {
    private FrameFixture frame;
    private Utilidades util;
    private ControlFichas control;
    
    public Pruebas_Menu_item() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Vista vista=new Vista();
        control=vista.getControl();
        frame=new FrameFixture(vista);
        frame.show();
        util=new Utilidades(frame);
        util.marcaItem(frame.menuItem(MENU_AGREGAR));
        frame.textBox(EDITEXT_NOMBRE_EDICION).setText("abc");
        frame.textBox(EDITEXT_EDAD_EDICION).setText("5");
        frame.textBox(EDITEXT_PRECIO_EDICION).setText("6");
        frame.comboBox(COMBO_MARCA_EDICION).selectItem(3);
        frame.comboBox(COMBO_TIPO_EDICION).selectItem(2);
        frame.button(BOTON_ACEPTAR_EDICION).click();
        frame.optionPane().yesButton().click();
        frame.textBox(EDITEXT_NOMBRE_EDICION).setText("def");
        frame.textBox(EDITEXT_EDAD_EDICION).setText("6");
        frame.textBox(EDITEXT_PRECIO_EDICION).setText("7");
        frame.comboBox(COMBO_MARCA_EDICION).selectItem(2);
        frame.comboBox(COMBO_TIPO_EDICION).selectItem(3);
        frame.button(BOTON_ACEPTAR_EDICION).click();
        frame.optionPane().yesButton().click();
        frame.textBox(EDITEXT_NOMBRE_EDICION).setText("ghi");
        frame.textBox(EDITEXT_EDAD_EDICION).setText("8");
        frame.textBox(EDITEXT_PRECIO_EDICION).setText("9");
        frame.comboBox(COMBO_MARCA_EDICION).selectItem(4);
        frame.comboBox(COMBO_TIPO_EDICION).selectItem(4);
        frame.button(BOTON_ACEPTAR_EDICION).click();
        frame.optionPane().noButton().click();
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    @Test
    public void Test1agregar() {
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture agregar=frame.menuItem(MENU_AGREGAR);
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        assertTrue(vista.component().isVisible());
        archivo.click();
        agregar.click();
        JPanelFixture edicion=frame.panel(PANEL_EDICION);
        assertTrue(edicion.component().isVisible());
        assertTrue(!vista.component().isVisible());
    }
    
    @Test
    public void Test2modificar() {
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture modificar=frame.menuItem(MENU_MODIFICAR);
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        assertTrue(vista.component().isVisible());
        archivo.click();
        modificar.click();
        JPanelFixture edicion=frame.panel(PANEL_EDICION);
        assertTrue(edicion.component().isVisible());
        assertTrue(!vista.component().isVisible());
    }
    
    @Test
    public void Test3borrar() {
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture borrar=frame.menuItem(MENU_BORRAR);
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        int antes=control.getTamanoCarrousel();
        assertTrue(vista.component().isVisible());
        archivo.click();
        borrar.click();
        frame.optionPane().yesButton().click();
        assertTrue((antes-1)==control.getTamanoCarrousel());
    }
    
    @Test
    public void Test4Filtrar(){
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture filtrar=frame.menuItem(MENU_FILTRAR);
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        assertTrue(vista.component().isVisible());
        archivo.click();
        filtrar.click();
        JPanelFixture filtrado=frame.panel(PANEL_FILTRO);
        assertTrue(filtrado.component().isVisible());
        assertTrue(!vista.component().isVisible());
    }
    
    @Test
    public void Test5Vista(){
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture filtrar=frame.menuItem(MENU_FILTRAR);
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        assertTrue(vista.component().isVisible());
        archivo.click();
        filtrar.click();
        JPanelFixture filtrado=frame.panel(PANEL_FILTRO);
        assertTrue(filtrado.component().isVisible());
        assertTrue(!vista.component().isVisible());
        JMenuItemFixture vistaAtras=frame.menuItem(MENU_VISTA);
        archivo.click();
        vistaAtras.click();
        assertTrue(vista.component().isVisible());
    }
    
    @Test
    public void Test6Guardar(){
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture guardar=frame.menuItem(MENU_GUARDAR);
        archivo.click();
        guardar.click();
        assertTrue(new File("imagenes\\guardado.json").exists());
    }
    
    @Test
    public void Test7Cargar(){
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        JMenuItemFixture borrar=frame.menuItem(MENU_BORRAR);
        JMenuItemFixture cargar=frame.menuItem(MENU_CARGAR);
        archivo.click();
        borrar.click();
        frame.optionPane().yesButton().click();
        archivo.click();
        borrar.click();
        frame.optionPane().yesButton().click();
        cargar.click();
        assertTrue(control.getTamanoCarrousel()==3);
    }
}
