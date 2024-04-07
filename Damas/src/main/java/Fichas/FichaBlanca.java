/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;

import Abstraccion.IFicha;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FichaBlanca implements IFicha{
    private ImageIcon fichan;
    private JButton boton;

 


    @Override
    public void setboton(JButton boton) {
        this.boton=boton;
        boton.setIcon(fichan);
    }

    @Override
    public JButton getboton() {
          return boton;
    }
@Override
    public IFicha clonar(){
       
        IFicha Blanca= new FichaBlanca();
        Blanca.setboton(this.boton);
        Blanca.setFichan(this.fichan);
        return Blanca;
    }

    @Override
    public void setFichan(ImageIcon fichan) {
        this.fichan = fichan;
    }

    
}
