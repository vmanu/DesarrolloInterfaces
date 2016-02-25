/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.calculadoramaven.Calculadora;
import com.mycompany.calculadoramaven.ConstantesPrueba;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dam2
 */
public class TesterBotones {
    private FrameFixture frame;
    private TesterUtilities testerUtiles;
    
    public TesterBotones() {
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
    public void sumaBienBotones(){
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,ConstantesPrueba.BOTON_SUMAR,ConstantesPrueba.LABEL_RES_BOTON,"4","7","11",null,false);
    }
    
    @Test
    public void restaBienBotones(){
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,ConstantesPrueba.BOTON_RESTAR,ConstantesPrueba.LABEL_RES_BOTON,"4","7","-3",null,false);
    }
    
    @Test
    public void multiplicaBienBotones(){
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,ConstantesPrueba.BOTON_MULTIPLICA,ConstantesPrueba.LABEL_RES_BOTON,"4","5","20",null,false);
    }
    
    @Test
    public void divideBienBotones(){
        testerUtiles.operaBien(ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,ConstantesPrueba.BOTON_DIVIDE,ConstantesPrueba.LABEL_RES_BOTON,"20","5","4",null,false);
    }
    
    @Test
    public void errorCajaTextoLetrasYVaciosBotones() {
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_SUMAR,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_RESTAR,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_MULTIPLICA,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,true);
        testerUtiles.errorCajaTextoLetrasYVacios(ConstantesPrueba.BOTON_DIVIDE,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,true);
    }
    
    @Test
    public void vuelveBlancoCajaTextoBotones(){
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_SUMAR, ConstantesPrueba.TEXTFIELD_OP1_BOTON, ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_RESTAR, ConstantesPrueba.TEXTFIELD_OP1_BOTON, ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_MULTIPLICA, ConstantesPrueba.TEXTFIELD_OP1_BOTON, ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.vuelveBlancoCajaTexto(ConstantesPrueba.BOTON_DIVIDE, ConstantesPrueba.TEXTFIELD_OP1_BOTON, ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
    }
    
    @Test
    public void errorDecimalesBotones() {
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_SUMAR,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_RESTAR,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_MULTIPLICA,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
        testerUtiles.errorDecimales(ConstantesPrueba.BOTON_DIVIDE,ConstantesPrueba.TEXTFIELD_OP1_BOTON,ConstantesPrueba.TEXTFIELD_OP2_BOTON,null,false);
    }
}
