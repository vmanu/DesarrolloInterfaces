/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static constantes.Constantes.*;
import control.ControlCoches;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Coche;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import utilidades.Utilidades;
import vista.JFrameCoches;

/**
 *
 * @author Victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Funcionalidades {
    private static ControlCoches control;
    private static FrameFixture frame;
    private static Utilidades util;
    
    public Funcionalidades() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        JFrameCoches vista=new JFrameCoches();
        control=vista.getControl();
        frame=new FrameFixture(vista);
        frame.show();
        util=new Utilidades(frame,control);
    }
    
    @AfterClass
    public static void tearDownClass() {
        frame.cleanUp();
    }
    
    @Before
    public void setUp() {
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_VISTA).click();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Test1agregaFicha() {
        int antes=control.getCantidadCoches();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_AGREGAR).click();
        frame.textBox(EDITEXT_MODELO_AGREGA).setText("Astra");
        frame.textBox(EDITEXT_PRECIO_AGREGA).setText("500000");
        frame.comboBox(COMBO_A).selectItem(0);
        frame.radioButton(RADIOBUTTON_A_5).click();
        frame.button(BOTON_ACEPTAR_AGREGA).click();
        assertEquals((antes+1), control.getCantidadCoches());
        frame.button(BOTON_ANTERIOR_VISTA).click();
        assertEquals(frame.label(LABEL_MARCA).text(), "Opel");
        assertEquals(frame.label(LABEL_MODELO).text(), "Astra");
        assertEquals(frame.label(LABEL_PRECIO).text(), "500000.0");
        assertTrue(frame.radioButton(RADIOBUTTON_C_5).component().isSelected());
    }
    
    @Test
    public void Test2fallaAgregando() {
        int antes=control.getCantidadCoches();
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_AGREGAR).click();
        frame.textBox(EDITEXT_MODELO_AGREGA).setText("Astra");
        frame.textBox(EDITEXT_PRECIO_AGREGA).setText("a");
        frame.comboBox(COMBO_A).selectItem(0);
        frame.radioButton(RADIOBUTTON_A_5).click();
        frame.button(BOTON_ACEPTAR_AGREGA).click();
        frame.optionPane().okButton().click();
        assertEquals((antes), control.getCantidadCoches());
        assertEquals(frame.textBox(EDITEXT_PRECIO_AGREGA).component().getBackground(), Color.red);
    }
    
    @Test
    public void Test3Siguiente(){
        assertEquals(frame.label(LABEL_MARCA).text(), "Opel");
        assertEquals(frame.label(LABEL_MODELO).text(), "Astra");
        assertEquals(frame.label(LABEL_PRECIO).text(), "500000.0");
        assertTrue(frame.radioButton(RADIOBUTTON_C_5).component().isSelected());
        frame.button(BOTON_SIGUIENTE_VISTA).click();
        assertEquals(frame.label(LABEL_MARCA).text(), "audi");
        assertEquals(frame.label(LABEL_MODELO).text(), "A8");
        assertEquals(frame.label(LABEL_PRECIO).text(), "20000.2");
        assertTrue(frame.radioButton(RADIOBUTTON_C_5).component().isSelected());
    }
    
    @Test
    public void Test4Filtrar(){
        //Filtrar por 5 Asientos
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_FILTRAR).click();
        frame.radioButton(RADIOBUTTON_B_5).click();
        frame.button(BOTON_ACEPTAR_FILTRO).click();
        ArrayList<Coche> filtro=util.setFiltro("", "", 5, false, 0);
        assertEquals(frame.label(LABEL_MARCA).text(), filtro.get(0).getMarca());
        assertEquals(frame.label(LABEL_MODELO).text(), filtro.get(0).getModelo());
        assertEquals(frame.label(LABEL_PRECIO).text(), filtro.get(0).getPrecio()+"");
        assertTrue(frame.radioButton(RADIOBUTTON_C_5).component().isSelected());
    }
    
    @Test
    public void Test5FiltraYFalla(){
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_FILTRAR).click();
        frame.button(BOTON_ACEPTAR_FILTRO).click();
        JOptionPaneFixture panel=frame.optionPane();
        assertEquals(panel.component().getMessage().toString(), "Filtro no arroja resultados");
        panel.okButton().click();
    }
}
