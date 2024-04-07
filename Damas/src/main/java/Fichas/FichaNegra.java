
package Fichas;

import Abstraccion.IFicha;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class FichaNegra implements IFicha{
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
