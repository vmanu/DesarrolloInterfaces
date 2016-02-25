package pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.reloj.Reloj;
import static constantes.Constantes.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author dam2
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebaBotones {
    private static FrameFixture frame;
    private static Reloj reloj;
    
    public PruebaBotones() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        reloj=new Reloj();
        frame=new FrameFixture(reloj);
        frame.show();
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
    public void Test1startButton() {
        int milIni=reloj.getMilliseconds();
        int secIni=reloj.getSeconds();
        int minIni=reloj.getMinutes();
        frame.button(START).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        int milFin=reloj.getMilliseconds();
        int secFin=reloj.getSeconds();
        int minFin=reloj.getMinutes();
        assertEquals(secFin, secIni+2);
        assertEquals(minFin, minIni);
        assertEquals(milFin, milIni);
    }
    
    @Test
    public void Test2pauseButton() {
        int milIni=reloj.getMilliseconds();
        int secIni=reloj.getSeconds();
        int minIni=reloj.getMinutes();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(PAUSE).click();
        int secFin=reloj.getSeconds();
        int minFin=reloj.getMinutes();
        assertEquals(secFin, secIni+2);
        assertEquals(minFin, minIni);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(PAUSE).click();
        int secFin2=reloj.getSeconds();
        int minFin2=reloj.getMinutes();
        assertEquals(secFin2, secFin);
        assertEquals(minFin2, minFin);
        
    }
    
    @Test
    public void Test3resetButton() {
        frame.button(START).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(RESET).click();
        int mil=reloj.getMilliseconds();
        int sec=reloj.getSeconds();
        int min=reloj.getMinutes();
        assertEquals(mil, 0);
        assertEquals(sec, 0);
        assertEquals(min, 0);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        mil=reloj.getMilliseconds();
        sec=reloj.getSeconds();
        min=reloj.getMinutes();
        assertEquals(mil, 0);
        assertEquals(sec, 0);
        assertEquals(min, 0);
    }
    
    @Test
    public void Test4lapButton() {
        frame.button(START).click();
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(LAP).click();
        try {
            TimeUnit.MILLISECONDS.sleep(1700);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(LAP).click();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaBotones.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.button(LAP).click();
        String muestra1=frame.label(VUELTA1).text();
        String muestra2=frame.label(VUELTA2).text();
        String muestra3=frame.label(VUELTA3).text();
        assertEquals(muestra1, "00:00:01.7");
        assertEquals(muestra2, "00:00:03.6");
        assertEquals(muestra3, "00:00:04.8");
    }
    
    @Test
    public void Test5lapButtonDisabled() {
        assertTrue(!frame.button(LAP).target.isEnabled());
    }
    
    @Test
    public void Test6cleanUpWhenResetAndLaps() {
        String muestra1=frame.label(VUELTA1).text();
        String muestra2=frame.label(VUELTA2).text();
        String muestra3=frame.label(VUELTA3).text();
        assertTrue(muestra1.equals("00:00:01.7")&&muestra2.equals("00:00:03.6")&&muestra3.equals("00:00:04.8"));
        frame.button(RESET).click();
        muestra1=frame.label(VUELTA1).text();
        muestra2=frame.label(VUELTA2).text();
        muestra3=frame.label(VUELTA3).text();
        assertTrue(muestra1.equals("Vuelta 1")&&muestra2.equals("Vuelta 2")&&muestra3.equals("Vuelta 3")&&frame.button(LAP).target.isEnabled());
    }
}
