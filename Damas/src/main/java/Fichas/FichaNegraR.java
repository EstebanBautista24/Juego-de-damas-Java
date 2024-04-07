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
public class FichaNegraR extends DecoradorFicha{
     private ImageIcon fichan;
    private JButton boton;
    private IFicha fichanegra;
     public FichaNegraR(IFicha fichanegra) {
        this.fichanegra=fichanegra;
    }
    @Override
    public void CambioReina() {
        fichanegra.setFichan(new ImageIcon("./imagenes/FichaNegraR.png"));
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
       
        IFicha Negra= new FichaNegra();
        Negra.setboton(this.boton);
        Negra.setFichan(this.fichan);
        
        return Negra;
    }
    @Override
     public void setFichan(ImageIcon fichan) {
        this.fichan = fichan;
    }
}
