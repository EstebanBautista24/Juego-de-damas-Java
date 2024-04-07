/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectofinalmodelos;

import Logica.Damas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
    public class Proyecto extends JFrame implements ActionListener{
       private Damas damas;
       public Proyecto(){

            damas = new Damas();
           this.setSize(1500, 800);
            JPanel tableroPrincipal=damas.getTablero().gettablero();
           this.add(damas.getVm().getPanelIzq());
           this.add(damas.getVm().getPanelDer());

           this.add(tableroPrincipal);
           this.setVisible(true);
           this.setTitle("Damas");
           damas.getVm().getBtnReinicio().addActionListener(this);

           setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       }
       public void reiniciar() {
        this.dispose(); 
        new Proyecto(); 
    }
       public static void main(String[] args) {
                    new Proyecto();
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.reiniciar();
    }
    }
