/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ficha;

/**
 *
 * @author dam2
 */
public class Carrousel_DAO {
    public ArrayList<Ficha> carga() {
        ArrayList<Ficha> fichas = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            fichas = mapper.readValue(new File("imagenes\\guardado.json"), 
                    new TypeReference<ArrayList<Ficha>>() {
            });

        } catch (IOException ex) {
            Logger.getLogger(Carrousel_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Ficha fi:fichas){
            if(!new File(fi.getPathImageMostrar()).exists()){
                fi.reescaladoImagen();
            }
        }
        return fichas;
    }

    public void guarda(ArrayList<Ficha> fichas) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("imagenes\\guardado.json"), fichas);
        } catch (IOException ex) {
            Logger.getLogger(Carrousel_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
