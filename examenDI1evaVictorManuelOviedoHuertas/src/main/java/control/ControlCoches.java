/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CochesDAO;
import java.util.ArrayList;
import model.Coche;

/**
 *
 * @author oscar
 */
public class ControlCoches {

    private ArrayList<Coche> coches;
    private int index;

    public ControlCoches() {
        coches = new ArrayList<>();
        index = 0;
    }

    public void cargar() {
        CochesDAO dao = new CochesDAO();
        coches = dao.load();
    }

    public void agregarCoche(String marca, String modelo, int asientos, double precio) {
        coches.add(new Coche(marca,modelo,asientos,precio));
    }

    public int getCantidadCoches() {
        return coches.size();
    }

    public Coche getCocheActual() {
        return coches.get(index);
    }

    public void siguiente() {
        index++;
        index%=coches.size();
    }

    public void anterior() {
        index--;
        if(index<0){
            index=coches.size()-1;
        }
    }

    public ArrayList<Coche> getTodosCoches(){
        return coches;
    }

    public int getIndex() {
        return index;
    }
}
