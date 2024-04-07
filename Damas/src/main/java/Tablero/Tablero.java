/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class Tablero extends JPanel {

    private static Tablero instanciaTablero;
    private JButton boton[][];
        private int tamanoBoton = 95; 
    private int filas = 8;
    private int columnas = 8;

    public JButton getboton(int i, int j) {
        return boton[i][j];
    }

    public void iniciar() {
        boton = new JButton[8][8];
        removeAll();
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                   boton[i][j] = new JButton();
                    boton[i][j].setBackground(Color.WHITE);
                    boton[i][j].setPreferredSize(new Dimension(tamanoBoton, tamanoBoton));

            }
        }
    }

    public void alinear() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
      
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                panel.add(boton[i][j]);
            }
        }

        add(panel);
    }


    public Tablero() {
         this.filas = filas;
        this.columnas = columnas;
        this.tamanoBoton = tamanoBoton;
     

        iniciar();
   
         setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); 
         setPreferredSize(new Dimension(1500, 800));
        setVisible(true);
        alinear();

     

    }

    public static Tablero getInstance() {
        if (instanciaTablero == null) {
            instanciaTablero = new Tablero();
        }
        return instanciaTablero;
    }

    public JButton[][] getBoton() {
        return boton;
    }

}
