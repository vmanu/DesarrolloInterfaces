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
import vista.JFrameCoches;
import control.ControlCoches;
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
    private static ControlCoches control;
    private static FrameFixture frame;
    private static Utilidades util;
    
    public Pruebas_Menu_item() {
        
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Test1Vista(){
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_VISTA).click();
        assertTrue(frame.panel(PANEL_VISTA).component().isVisible());
    }
    
    @Test
    public void Test2agregar() {
        JPanelFixture vista=frame.panel(PANEL_VISTA);
        assertTrue(vista.component().isVisible());
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_AGREGAR).click();
        assertTrue(frame.panel(PANEL_ADD).component().isVisible());
        assertTrue(!vista.component().isVisible());
    }
    
    @Test
    public void Test3Filtrar(){
        frame.menuItem(MENU_ARCHIVO).click();
        frame.menuItem(MENU_FILTRAR).click();
        assertTrue(frame.panel(PANEL_BUSCAR).component().isVisible());
    }
}
