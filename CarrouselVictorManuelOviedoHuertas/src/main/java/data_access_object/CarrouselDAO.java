/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_object;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_access_object.ImagenDAO;
import modelo.Imagen;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class CarrouselDAO {
    
    public ArrayList<Imagen> carga(String ruta) {
        ArrayList<Imagen> imagenes = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            imagenes = mapper.readValue(new File(ruta), 
                    new TypeReference<ArrayList<Imagen>>() {
            });

        } catch (IOException ex) {
            Logger.getLogger(ImagenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Imagen im:imagenes){
            if(!im.compruebaSiExiste()){
                im.setDimensionImagen();
            }
        }
        return imagenes;
    }

    public void guarda(ArrayList<Imagen> imagenes,String ruta) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(ruta), imagenes);
        } catch (IOException ex) {
            Logger.getLogger(ImagenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
