/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.calculadoramaven.Calculadora;
import com.mycompany.calculadoramaven.ConstantesPrueba;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JTabbedPaneFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dam2
 */
public class TesterRadios {
    private FrameFixture frame;
    private TesterUtilities testerUtiles;
    
    public TesterRadios() {
    }
    
    @Before
    public void setUp() {
        frame=new FrameFixture(new Calculadora());
        frame.show();
        testerUtiles=new TesterUtilities(frame);
    }
    
    @After
    public void tearDown() {
        frame.cleanUp();
    }

    @Test
    public void sumaBienRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"4","7","11",ConstantesPrueba.RADIO_SUMAR,true);
    }
    
    @Test
    public void restaBienRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"4","7","-3",ConstantesPrueba.RADIO_RESTA,true);
    }
    
    @Test
    public void multiplicaBienRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"4","5","20",ConstantesPrueba.RADIO_MULTIPLICA,true);
    }
    
    @Test
    public void divideBienRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"20","5","4",ConstantesPrueba.RADIO_DIVIDE,true);
    }
    
    @Test
    public void vuelveBlancoCajaTextoRadios(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_RADIO, ConstantesPrueba.TEXTFIELD_OP1_RADIO, ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_SUMAR,true);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_RADIO, ConstantesPrueba.TEXTFIELD_OP1_RADIO, ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_RESTA,true);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_RADIO, ConstantesPrueba.TEXTFIELD_OP1_RADIO, ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_MULTIPLICA,true);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_RADIO, ConstantesPrueba.TEXTFIELD_OP1_RADIO, ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_DIVIDE,true);
    }
    
    @Test
    public void errorCajaTextoLetrasYVaciosRadios() {
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_SUMAR,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_RESTA,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_MULTIPLICA,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_DIVIDE,true);
    }
    
    @Test
    public void errorDecimalesRadios() {
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_SUMAR,true);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_RESTA,true);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_MULTIPLICA,true);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.RADIO_DIVIDE,true);
    }
    
    @Test
    public void sumaBienDecimalesRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        frame.checkBox(ConstantesPrueba.CHECKBOX).check();
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"20.25","5.5","25,75",ConstantesPrueba.RADIO_SUMAR,true);
    }
    
    @Test
    public void restaBienDecimalesRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        frame.checkBox(ConstantesPrueba.CHECKBOX).check();
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"20.25","5.5","14,75",ConstantesPrueba.RADIO_RESTA,true);
    }
    
    @Test
    public void multiplicaBienDecimalesRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        frame.checkBox(ConstantesPrueba.CHECKBOX).check();
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"20.25","5.5","111,375",ConstantesPrueba.RADIO_MULTIPLICA,true);
    }
    
    @Test
    public void divideBienDecimalesRadio(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_RADIO);
        frame.checkBox(ConstantesPrueba.CHECKBOX).check();
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_RADIO,ConstantesPrueba.TEXTFIELD_OP2_RADIO,ConstantesPrueba.BOTON_IGUAL_RADIO,ConstantesPrueba.LABEL_RES_RADIO,"20.25","5.5","3,681818182",ConstantesPrueba.RADIO_DIVIDE,true);
    }
}
