/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import static constantes.Constantes.*;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JMenuItemFixture;

/**
 *
 * @author Victor
 */
public class Utilidades {
    private FrameFixture frame;
    
    public Utilidades(FrameFixture frame){
        this.frame=frame;
    }
    
    public void marcaItem(JMenuItemFixture s){
        JMenuItemFixture archivo=frame.menuItem(MENU_ARCHIVO);
        archivo.click();
        s.click();
    }
}
