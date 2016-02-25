/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.calculadoramaven.ConstantesPrueba;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.fest.swing.core.MouseButton;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.fest.swing.fixture.JRadioButtonFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class TesterUtilities {

    private FrameFixture frame;

    public TesterUtilities(FrameFixture frame) {
        this.frame = frame;
    }

    public void errorCajaTextoLetrasYVacios(String boton, String textField1, String textField2,String operacion,boolean radio) {
        errorCajaTexto(boton, textField1, textField2, "a", "4", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la izquierda.", true, false,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "4", "a", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la derecha.", false, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "a", "a", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la izquierda.\nSe ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la derecha.", true, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "", "4", "No ha introducido valor en la celda de la izquierda.", true, false,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "4", "", "No ha introducido valor en la celda de la derecha.", false, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "", "", "No ha introducido valor en la celda de la izquierda.\nNo ha introducido valor en la celda de la derecha.", true, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "", "a", "No ha introducido valor en la celda de la izquierda.\nSe ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la derecha.", true, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "a", "", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la izquierda.\nNo ha introducido valor en la celda de la derecha.", true, true,operacion,radio);
    }

    public void errorCajaTexto(String boton, String campo1, String campo2, String valorCampo1, String valorCampo2, String mensajeErrorEsperado, boolean assertEqualsOp1, boolean assertEqualsOp2,String operacion,boolean radio) {
        JButtonFixture bt = frame.button(boton);
        JTextComponentFixture text1 = frame.textBox(campo1);
        JTextComponentFixture text2 = frame.textBox(campo2);
        text1.setText(valorCampo1);
        text2.setText(valorCampo2);
        if (operacion != null) {
            if (radio) {
                JRadioButtonFixture rb = frame.radioButton(operacion);
                rb.click();
            } else {
                JComboBoxFixture cb = frame.comboBox(ConstantesPrueba.COMBO_OP);
                cb.selectItem(operacion);
            }
        }
        bt.click();
        JOptionPaneFixture op = frame.optionPane();
        if (assertEqualsOp1) {
            assertEquals(text1.target.getBackground(), Color.RED);
        } else {
            assertNotEquals(text1.target.getBackground(), Color.RED);
        }
        if (assertEqualsOp2) {
            assertEquals(text2.target.getBackground(), Color.RED);
        } else {
            assertNotEquals(text2.target.getBackground(), Color.RED);
        }
        assertEquals(op.target.getMessageType(), JOptionPane.ERROR_MESSAGE);
        assertEquals(op.target.getMessage(), mensajeErrorEsperado);
        op.okButton().click();
    }

    public void operaBien(String TxtField1, String TxtField2, String Boton, String Label, String Valor1, String Valor2, String Resultado,String operacion,boolean radio) {
        JTextComponentFixture text1 = frame.textBox(TxtField1);
        JTextComponentFixture text2 = frame.textBox(TxtField2);
        text1.setText(Valor1);
        text2.setText(Valor2);
        if (operacion != null) {
            if (radio) {
                JRadioButtonFixture rb = frame.radioButton(operacion);
                rb.click();
            } else {
                JComboBoxFixture cb = frame.comboBox(ConstantesPrueba.COMBO_OP);
                cb.selectItem(operacion);
            }
        }
        JButtonFixture bt = frame.button(Boton);
        bt.click();
        JLabelFixture label = frame.label(Label);
        assertEquals(label.target.getText(), Resultado);
    }

    public void vuelveBlancoCajaTexto(String button, String textField1, String textField2, String operacion, boolean radio) {//BUTON ES EL BUTON EN LOS BOTONES Y EL IGUAL EN LOS OTROS
        JButtonFixture bt = frame.button(button);
        JTextComponentFixture text1 = frame.textBox(textField1);
        JTextComponentFixture text2 = frame.textBox(textField2);
        text1.setText("");
        text2.setText("");
        if (operacion != null) {
            if (radio) {
                JRadioButtonFixture rb = frame.radioButton(operacion);
                rb.click();
            } else {
                JComboBoxFixture cb = frame.comboBox(ConstantesPrueba.COMBO_OP);
                cb.selectItem(operacion);
            }
        }
        bt.click();
        JOptionPaneFixture op = frame.optionPane();
        assertEquals(text1.target.getBackground(), Color.RED);
        assertEquals(text2.target.getBackground(), Color.RED);
        assertEquals(op.target.getMessageType(), JOptionPane.ERROR_MESSAGE);
        op.okButton().click();
        text1.click(MouseButton.LEFT_BUTTON);
        text2.click(MouseButton.LEFT_BUTTON);
        assertEquals(text1.target.getBackground(), Color.WHITE);
        assertEquals(text2.target.getBackground(), Color.WHITE);
    }
    
    public void errorDecimales(String boton, String textField1, String textField2,String operacion,boolean radio) {
        errorCajaTexto(boton, textField1, textField2, "2.2", "4", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la izquierda.", true, false,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "4", "2.2", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la derecha.", false, true,operacion,radio);
        errorCajaTexto(boton, textField1, textField2, "2.2", "2.2", "Se ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la izquierda.\nSe ha introducido un valor no numérico o numérico en formato incorrecto en la celda de la derecha.", true, true,operacion,radio);
    }
}
