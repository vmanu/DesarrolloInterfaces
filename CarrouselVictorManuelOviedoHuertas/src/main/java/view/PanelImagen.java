/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Victor
 */
public class PanelImagen extends JPanel{
    private BufferedImage imagen;
    
    public PanelImagen(){
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
        this.repaint();
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paintComponent(grphcs);
        //AQUI CONTROLAMOS QUE SE COLOQUE EN EL CENTRO
        if(imagen!=null){
            int x=(this.getWidth()-imagen.getWidth())/2;
            int y=(this.getHeight()-imagen.getHeight())/2;
            grphcs.drawImage(imagen,x, y, null);
        }else{
            grphcs.drawImage(imagen,0, 0, null);
        }
    }
}
