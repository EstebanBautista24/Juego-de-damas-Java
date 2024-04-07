
package Abstraccion;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public interface IFicha {

   
    public abstract  void setboton(JButton boton);
    public abstract  JButton getboton();
    public abstract IFicha clonar();
    public abstract void setFichan(ImageIcon fichan);
}
