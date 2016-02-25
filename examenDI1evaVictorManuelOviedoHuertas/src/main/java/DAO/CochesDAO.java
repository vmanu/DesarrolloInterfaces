/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Coche;

/**
 *
 * @author oscar
 */
public class CochesDAO {
    
    
    public ArrayList<Coche> load() {
        ArrayList<Coche> coches = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            coches = mapper.readValue(getClass().getResourceAsStream("/coches.json"), 
                    new TypeReference<ArrayList<Coche>>() {
            });

        } catch (IOException ex) {
            Logger.getLogger(CochesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coches;
    }
    
}
