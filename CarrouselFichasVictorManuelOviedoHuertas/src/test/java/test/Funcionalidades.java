/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static constantes.Constantes.*;
import control.ControlFichas;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import utilidades.Utilidades;
import view.Vista;

/**
 *
 * @author Victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Funcionalidades {
    private static ControlFichas control;
    private static FrameFixture frame;
    private static Utilidades util;
    
    public Funcionalidades() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Test1agregaFicha() {
        int antes=control.getTamanoCarrousel();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_AGREGAR).click();
        frame.textBox(EDITEXT_NOMBRE_EDICION).setText("Prueba unitaria");
        frame.textBox(EDITEXT_EDAD_EDICION).setText("5");
        frame.textBox(EDITEXT_PRECIO_EDICION).setText("6");
        frame.comboBox(COMBO_MARCA_EDICION).selectItem(3);
        frame.comboBox(COMBO_TIPO_EDICION).selectItem(1);
        frame.button(BOTON_ACEPTAR_EDICION).click();
        frame.optionPane().noButton().click();
        assertEquals((antes+1), control.getTamanoCarrousel());
    }
    
    @Test
    public void Test2modificarFicha() {
        int antes=control.getTamanoCarrousel();
        frame.button(BOTON_ANTERIOR_VISTA).click();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_MODIFICAR).click();
        assertEquals(frame.textBox(EDITEXT_NOMBRE_EDICION).text(), "Prueba unitaria");
        assertEquals(frame.textBox(EDITEXT_EDAD_EDICION).text(), "5");
        assertEquals(frame.textBox(EDITEXT_PRECIO_EDICION).text(), "6.0");
        assertEquals(frame.comboBox(COMBO_MARCA_EDICION).target.getSelectedIndex(), 3);
        assertEquals(frame.comboBox(COMBO_TIPO_EDICION).target.getSelectedIndex(), 1);
        frame.textBox(EDITEXT_NOMBRE_EDICION).setText("Prueba modificada");
        frame.button(BOTON_ACEPTAR_EDICION).click();
        assertEquals(antes, control.getTamanoCarrousel());
        assertEquals(frame.label(TEXTVIEW_NOMBRE_VISTA).text(), "Prueba modificada");
    }
    
    @Test
    public void Test3Filtrar(){
        int antes=control.getTamanoCarrousel();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_FILTRAR).click();
        frame.comboBox(COMBO_MARCA_FILTRO).selectItem(4);
        frame.button(BOTON_ACEPTAR_FILTRO).click();
        assertEquals(2, Integer.parseInt(frame.label(LABEL_INDEX_MAX_VISTA).text()));
        frame.button(BOTON_CANCELA_FILTRO_VISTA).click();
        assertEquals(antes, Integer.parseInt(frame.label(LABEL_INDEX_MAX_VISTA).text()));
    }
    
    @Test
    public void Test4irAdelante(){
        int tamano=control.getTamanoCarrousel();
        int antes=Integer.parseInt(frame.label(LABEL_INDEX_VISTA).text());
        frame.button(BOTON_SIGUIENTE_VISTA).click();
        int despues=Integer.parseInt(frame.label(LABEL_INDEX_VISTA).text());
        assertEquals((antes+1)%tamano, despues);
        
    }
    
    @Test
    public void Test5irAtras(){
        int tamano=Integer.parseInt(frame.label(LABEL_INDEX_MAX_VISTA).text());
        int antes=Integer.parseInt(frame.label(LABEL_INDEX_VISTA).text());
        antes--;
        frame.button(BOTON_ANTERIOR_VISTA).click();
        int despues=Integer.parseInt(frame.label(LABEL_INDEX_VISTA).text());
        int value=(antes-1)<1?(tamano):(antes-1);
        assertEquals(value, despues);
        
    }
    
    @Test
    public void Test6Borrar(){
        int antes=control.getTamanoCarrousel();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_BORRAR).click();
        frame.optionPane().yesButton().click();
        int despues=control.getTamanoCarrousel();
        assertEquals(antes-1, despues);
        
    }
}
