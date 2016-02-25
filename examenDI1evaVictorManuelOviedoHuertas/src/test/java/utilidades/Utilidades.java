/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import static constantes.Constantes.*;
import control.ControlCoches;
import java.util.ArrayList;
import model.Coche;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;

/**
 *
 * @author Victor
 */
public class Utilidades {

    private FrameFixture frame;
    private ControlCoches controlCoches;

    public Utilidades(FrameFixture frame, ControlCoches control) {
        this.frame = frame;
        controlCoches = control;
    }

    public ArrayList<Coche> setFiltro(String marca, String modelo, int asientos, boolean bprecio, double precio) {
        ArrayList<Coche> borra = new ArrayList();
        ArrayList<Coche> filtro = new ArrayList();
        if (!marca.equalsIgnoreCase("")) {
            for (Coche f : controlCoches.getTodosCoches()) {
                if (f.getMarca().equalsIgnoreCase(marca)) {
                    filtro.add(f);
                }
            }
        }
        if (!modelo.equalsIgnoreCase("")) {
            if (modelo.equalsIgnoreCase("")) {
                for (Coche f : controlCoches.getTodosCoches()) {
                    if (f.getModelo().equalsIgnoreCase(modelo)) {
                        filtro.add(f);
                    }
                }
            } else {
                for (Coche f : filtro) {
                    if (!f.getModelo().equalsIgnoreCase(modelo)) {
                        borra.add(f);
                    }
                }
                filtro.removeAll(borra);
                borra.clear();
            }
        }
        if (asientos != 0) {
            if (modelo.equalsIgnoreCase("") && marca.equalsIgnoreCase("")) {
                for (Coche f : controlCoches.getTodosCoches()) {
                    if (f.getNumeroAsientos() == asientos) {
                        filtro.add(f);
                    }
                }
            } else {
                for (Coche f : filtro) {
                    if (f.getNumeroAsientos() != asientos) {
                        borra.add(f);
                    }
                }
                filtro.removeAll(borra);
                borra.clear();
            }
        }
        if (bprecio) {
            if (modelo.equalsIgnoreCase("") && marca.equalsIgnoreCase("") && asientos != 0) {
                for (Coche f : controlCoches.getTodosCoches()) {
                    if (f.getPrecio() == precio) {
                        filtro.add(f);
                    }
                }
            } else {
                for (Coche f : filtro) {
                    if (f.getPrecio() != precio) {
                        borra.add(f);
                    }
                }
                filtro.removeAll(borra);
                borra.clear();
            }
        }
        return filtro;
    }
}
