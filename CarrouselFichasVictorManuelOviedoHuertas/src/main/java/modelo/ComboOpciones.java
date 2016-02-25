/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import constantes.ComboItems;

/**
 *
 * @author oscar
 */
public class ComboOpciones {
    
    private String text;
    private ComboItems opcion;

    public ComboOpciones(String text, ComboItems operacion) {
        this.text = text;
        this.opcion = operacion;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ComboItems getOperacion() {
        return opcion;
    }

    public void setOperacion(ComboItems operacion) {
        this.opcion = operacion;
    }

    @Override
    public String toString() {
        return text ;
    }
}
