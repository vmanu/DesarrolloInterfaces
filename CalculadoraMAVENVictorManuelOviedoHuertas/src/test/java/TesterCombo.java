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
public class TesterCombo {
    private FrameFixture frame;
    private TesterUtilities testerUtiles;
    
    public TesterCombo() {
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
    public void sumaBienCombo(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_COMBO);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.LABEL_RES_COMBO,"4","7","11","SUMA",false);
    }
    
    @Test
    public void restaBienCombo(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(2);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.LABEL_RES_COMBO,"4","7","-3","RESTA",false);
    }
    
    @Test
    public void multiplicaBienCombo(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(2);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.LABEL_RES_COMBO,"4","5","20","MULTIPLICA",false);
    }
    
    @Test
    public void divideBienCombo(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(2);
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.LABEL_RES_COMBO,"20","5","4","DIVIDE",false);
    }
    
    @Test
    public void vuelveBlancoCajaTextoCombos(){
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_COMBO);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_COMBO, ConstantesPrueba.TEXTFIELD_OP1_COMBO, ConstantesPrueba.TEXTFIELD_OP2_COMBO,"SUMA",false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_COMBO, ConstantesPrueba.TEXTFIELD_OP1_COMBO, ConstantesPrueba.TEXTFIELD_OP2_COMBO,"RESTA",false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_COMBO, ConstantesPrueba.TEXTFIELD_OP1_COMBO, ConstantesPrueba.TEXTFIELD_OP2_COMBO,"MULTIPLICA",false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_IGUAL_COMBO, ConstantesPrueba.TEXTFIELD_OP1_COMBO, ConstantesPrueba.TEXTFIELD_OP2_COMBO,"DIVIDE",false);
    }
    
    @Test
    public void errorCajaTextoLetrasYVaciosCombos() {
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_COMBO);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"SUMA",false);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"RESTA",false);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"MULTIPLICA",false);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"DIVIDE",false);
    }
    
    @Test
    public void errorDecimalesCombos() {
        JTabbedPaneFixture pn=frame.tabbedPane(ConstantesPrueba.PANEL);
        pn.selectTab(ConstantesPrueba.PANEL_COMBO);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"SUMA",false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"RESTA",false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"MULTIPLICA",false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_IGUAL_COMBO,ConstantesPrueba.TEXTFIELD_OP1_COMBO,ConstantesPrueba.TEXTFIELD_OP2_COMBO,"DIVIDE",false);
    }
}
