/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.model;

import static constants.Constantes.*;
import controller.ControlCreator;
import controller.ControlJuegos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import model.Juego;

/**
 *
 * @author dam2
 */
public class TablaModeloJuego extends AbstractTableModel {

    private ArrayList<Juego> juegos;
    private boolean insertando;
    private ControlJuegos control;

    public TablaModeloJuego() {
        super();
        insertando = false;
        control = new ControlJuegos();
        juegos = control.getAllJuegos();
    }

    @Override
    public String getColumnName(int i) {
        String columnName = "";
        switch (i) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "NOMBRE";
                break;
            case 2:
                columnName = "FECHA";
                break;
            case 3:
                columnName = "VENTAS";
                break;
            case 4:
                columnName = "TIPO";
                break;
            case 5:
                columnName = "CREADOR";
                break;
        }
        return columnName;
    }

    /**
     * Recoge los valores de la tabla
     */
    @Override
    public Object getValueAt(int row, int col) {
        Juego game = juegos.get(row);
        Object o = null;
        switch (col) {
            case 0:
                o = game.getId();
                break;
            case 1:
                o = game.getNombre();
                break;
            case 2:
                o = game.getFecha_creacion();
                break;
            case 3:
                o = game.getVentas();
                break;
            case 4:
                o = game.getTipo();
                break;
            case 5:
                o = game.getCreador();
                break;
        }
        return o;
    }

    /**
     * Pinta en la tabla
     */
    @Override
    public void setValueAt(Object o, int row, int col) {
        if(row>=0&&col>0){
            Juego game = juegos.get(row);
            switch (col) {
                /*case 0:
                    game.setId((int)o);
                    break;*/
                case 1:
                    game.setNombre((String) o);
                    break;
                case 2:
                    game.setFecha_creacion((Date) o);
                    break;
                case 3:
                    game.setVentas(Integer.parseInt((String)o));
                    break;
                case 4:
                    LinkedHashMap<Integer,String> map=new ControlJuegos().getAllTipos();
                    for(Integer k:map.keySet()){
                        if(map.get(k).equals((String)o)){
                            game.setTipo(k);
                        }
                    }
                    break;
                case 5:
                    LinkedHashMap<Integer,String> creadores=new ControlCreator().getAllCreators();
                    for(Integer k:creadores.keySet()){
                        if(creadores.get(k).equals((String)o)){
                            game.setCreador(k);
                        }
                    }
                    break;
            }
            fireTableCellUpdated(row, col);
        }
    }

    public void deleteRow(Juego j) {
        int p=0;
        for(int i=0;i<juegos.size();i++){
            if(juegos.get(i).getId()==j.getId()){
                p=i;
            }
        }
        juegos.remove(p);
        fireTableDataChanged();
    }

    public void insertRow(String nombre, Date fecha,int ventas, int tipo, int creador) {
        if (insertando) {
            if (!nombre.isEmpty() && fecha != null&&ventas!=-1&&tipo!=-1&&creador!=-1) {
                insertando=false;
            }
        }
        fireTableRowsInserted(juegos.size() - 1, juegos.size() - 1);
    }

    public void insertRow() {
        insertando = true;
        juegos.add(new Juego(-1, "", null,-1,-1,-1));
        fireTableRowsInserted(juegos.size() - 1, juegos.size() - 1);
    }

    @Override
    public int getRowCount() {
        return juegos.size();
    }

    @Override
    public int getColumnCount() {
        return NUMERO_COLUMNAS;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col != 0; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isInsertando() {
        return insertando;
    }

    public void setJuegoWithRightId(Juego j) {
        juegos.remove(juegos.size()-1);
        juegos.add(j);
    }

    public void deleteLastRow() {
        juegos.remove(juegos.size()-1);
        insertando=false;
    }

    public void updateTable(int row) {
        ArrayList<Juego>juegosActualizado=control.getAllJuegos();
        for(Juego j:juegosActualizado){
            for(int i=0;i<juegos.size();i++){
                if(juegos.get(i).getId()==j.getId()&&!comparaJuegos(juegos.get(i), j)&&i!=row){
                    juegos.get(i).setNombre(j.getNombre());
                    juegos.get(i).setFecha_creacion(j.getFecha_creacion());
                    juegos.get(i).setCreador(j.getCreador());
                    juegos.get(i).setTipo(j.getTipo());
                    juegos.get(i).setVentas(j.getVentas());
                    for(int k=1;k<getColumnCount();k++){
                        fireTableCellUpdated(i, k);
                    }
                }
            }
        }
    }
    
    private boolean comparaJuegos(Juego j1,Juego j2){
        return j1.getCreador()==j2.getCreador()&&j1.getFecha_creacion().equals(j2.getFecha_creacion())&&j1.getNombre().equals(j2.getNombre())&&j1.getTipo()==j2.getTipo()&&j1.getVentas()==j2.getVentas();
    }
    
    
}
