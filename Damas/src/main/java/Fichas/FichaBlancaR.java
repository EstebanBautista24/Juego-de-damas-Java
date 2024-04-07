/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fichas;

import Abstraccion.DecoradorFicha;
import Abstraccion.IFicha;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author pc
 */
public class FichaBlancaR extends DecoradorFicha{
      private FichaBlanca fichablanca;
          private ImageIcon fichan;
    private JButton boton;

    public FichaBlancaR(FichaBlanca fichablanca) {
        this.fichablanca=fichablanca;
    }
    @Override
    public void CambioReina() {
        fichablanca.setFichan(new ImageIcon("./imagenes/FichaBlancaR.png"));
    }

    
    @Override
    public void setFichan(ImageIcon fichan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

  
}
