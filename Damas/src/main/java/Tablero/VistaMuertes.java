/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Logica.Damas;
import com.mycompany.proyectofinalmodelos.Proyecto;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Esteban
 */
public class VistaMuertes {

    private JPanel panelIzq;
    private JPanel panelDer;
    private JLabel jugador1;
    private JLabel jugador2;
    private JLabel img;
    private JButton btnReinicio;
    public VistaMuertes(){

        panelIzq();
        panelDer();
    }
    public void panelIzq(){
        jugador1 = new JLabel();
        img = new JLabel();
        
        panelIzq = new JPanel();
        panelIzq.setLayout(null);
        panelIzq.setBounds(0, 0, 360, 800);
        
        jugador1.setText("JUGADOR 1");
        jugador1.setBounds(0,20, 360, 50);
        jugador1.setHorizontalAlignment(SwingConstants.CENTER);
        jugador1.setVerticalAlignment(SwingConstants.CENTER);
        jugador1.setFont(new Font("Impact",Font.BOLD,40));
        
        img.setBounds(0, 0, 360, 800);
        img.setIcon(new ImageIcon("./imagenes/panel.png"));
        
       
        
        panelIzq.add(jugador1);
        panelIzq.add(img);
    }
    public void panelDer(){
        btnReinicio= new JButton();
        jugador2 = new JLabel();
        img = new JLabel();
        
        panelDer = new JPanel();
        panelDer.setLayout(null);
        panelDer.setBounds(1120, 0, 360, 800);
        
        jugador2.setText("JUGADOR 2");
        jugador2.setBounds(0, 20, 360, 50);
        jugador2.setHorizontalAlignment(SwingConstants.CENTER);
        jugador2.setVerticalAlignment(SwingConstants.CENTER);
        jugador2.setFont(new Font("Impact",Font.BOLD,40));
        
        btnReinicio.setBounds(80,600,200,100);
        btnReinicio.setText("Reiniciar Juego" );
        btnReinicio.setFont(new Font("Impact",Font.PLAIN,25));
        btnReinicio.setBackground(new Color(255, 217, 168));
        
        img.setBounds(0, 0, 360, 800);
        img.setIcon(new ImageIcon("./imagenes/panel.png"));
        
       
        panelDer.add(btnReinicio);
        panelDer.add(jugador2);
        panelDer.add(img);
        
    }

    public JPanel getPanelIzq() {
        return panelIzq;
    }

    public JLabel getJugador1() {
        return jugador1;
    }

    public JLabel getJugador2() {
        return jugador2;
    }

    public JPanel getPanelDer() {
        return panelDer;
    }

    public JButton getBtnReinicio() {
        return btnReinicio;
    }

   
    
}
