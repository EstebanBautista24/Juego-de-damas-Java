/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Fichas.FichaBlancaR;
import Fichas.FichaNegraR;
import Tablero.VistaMuertes;
import Tablero.TabFichas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author pc
 */
public class Damas implements ActionListener {

    private VistaMuertes vm;
    private TabFichas tablero;
    private String[][] tabla;
    private JButton[][] boton;
    private char color;
    public Damas() {

        vm = new VistaMuertes();
        tablero = new TabFichas();
        tabla = tablero.getTabficha();
        boton = tablero.gettablero().getBoton();
        botones();
        color = 'B';
        Turno();

    }

    public void botones() {
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                boton[i][j].addActionListener(this);
            }
        }
    }

    

    public void CambioTurno() {
        if (color == 'B') {
            color = 'N';
        } else {
            color = 'B';
        }
    }

    public boolean verificar_exitencia_de_ficha(char color, int x, int y) {
        if (color == 'N') {
            if (tabla[x][y] == "n" || tabla[x][y] == "rn") {
                return true;
            }
        } else if (color == 'B') {
            if (tabla[x][y] == "b" || tabla[x][y] == "rb") {
                return true;
            }
        }
        return false;
    }

    public boolean jugar(char color, int x, int y, int x1, int y1) {
        boolean pasa = false;
        String variable, reina, enemigo, Renemiga;
        if (color == 'B') {
            enemigo = "n";
            Renemiga = "rn";
            variable = "b";
            reina = "rb";

        } else {
            Renemiga = "rb";
            enemigo = "b";
            variable = "n";
            reina = "rn";
        }
        while (pasa == false) {

            if (tabla[x][y] == variable) {
                if (y1 > -1 && x1 > -1 && y1 < 8 && x1 < 8) {
                    if (tabla[x1][y1] == "relleno") {
                        if (variable == "b") {

                            if (x1 == x - 1) {

                                if (y1 == y - 1 || y1 == y + 1) {
                                    tabla[x][y] = "relleno";
                                    tabla[x1][y1] = "b";
                                    pasa = true;
                                }
                            }
                            if (x1 == x - 2) {
                                if (y1 == y + 2) {
                                    if (tabla[x - 1][y + 1] == enemigo || tabla[x - 1][y + 1] == Renemiga) {
                                        tabla[x - 1][y + 1] = "relleno";
                                        tabla[x][y] = "relleno";
                                        tabla[x1][y1] = "b";
                                        pasa = true;
                                    }
                                } else if (y1 == y - 2) {
                                    if (tabla[x - 1][y - 1] == enemigo || tabla[x - 1][y - 1] == Renemiga) {
                                        tabla[x - 1][y - 1] = "relleno";
                                        tabla[x][y] = "relleno";
                                        tabla[x1][y1] = "b";
                                        pasa = true;
                                    }

                                }
                            }

                        } else if (variable == "n") {
                            if (x1 == x + 1) {
                                if (y1 == y - 1 || y1 == y + 1) {
                                    tabla[x][y] = "relleno";
                                    tabla[x1][y1] = "n";
                                    pasa = true;
                                }
                            }
                            if (x1 == x + 2) {
                                if (y1 == y + 2) {
                                    if (tabla[x + 1][y + 1] == enemigo || tabla[x + 1][y + 1] == Renemiga) {
                                        tabla[x + 1][y + 1] = "relleno";
                                        tabla[x][y] = "relleno";
                                        tabla[x1][y1] = "n";
                                        pasa = true;
                                    }
                                } else if (y1 == y - 2) {
                                    if (tabla[x + 1][y - 1] == enemigo || tabla[x + 1][y + 1] == Renemiga) {
                                        tabla[x + 1][y - 1] = "relleno";
                                        tabla[x][y] = "relleno";
                                        tabla[x1][y1] = "n";
                                        pasa = true;
                                    }

                                }
                            }
                        }
                    }

                } else {
                    //JOptionPane.showMessageDialog(null, "coordenadas no validas");
                }
            } else if (tabla[x][y] == reina) {
                // movimiento reina
                int menorx = 0, menory = 0;

                if (x == x1 || y == y1) {
                    //JOptionPane.showMessageDialog(null, "movimiento invalido por movimiento en vertical/horizontal");
                } else if (tabla[x1][y1] == variable) {
                    //JOptionPane.showMessageDialog(null, "movimiento invalido por chocar con una ficha aliada");
                } else if (tabla[x1][y1] == "relleno") {
                    for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
                        menory = i;
                        menorx = j;
                    }
                    for (int i = menory, j = menorx; i < tabla[0].length; i++, j++) {
                        if (i == x1 && j == y1) {

                            if (x > x1 && y > y1) {

                                for (int j2 = x, i2 = y; i2 >= y1 || j2 >= x1; j2--, i2--) {
                                    if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

                                    } else {
                                        tabla[j2][i2] = "relleno";
                                        pasa = true;
                                    }

                                }
                            } else if (x < x1 && y < y1) {

                                for (int j2 = x, i2 = y; i2 < y1 || j2 < x1; j2++, i2++) {
                                    tabla[j2][i2] = "relleno";
                                    pasa = true;
                                }
                            }

                            tabla[x][y] = "relleno";
                            tabla[x1][y1] = reina;
                            pasa = true;
                        }
                    }
                    for (int i = x, j = y; i >= 0; i--, j++) {
                        menory = i;
                        menorx = j;
                    }
                    for (int i = menory, j = menorx; i < tabla[0].length; i++, j--) {
                        if (i == x1 && j == y1) {
                            if (x < x1 && y > y1) {

                                for (int j2 = x, i2 = y; i2 >= y1 || j2 < x1; j2++, i2--) {
                                    if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

                                    } else {
                                        tabla[j2][i2] = "relleno";
                                        pasa = true;
                                    }
                                }
                            } else if (x > x1 && y < y1) {
                                for (int j2 = x, i2 = y; i2 < y1 || j2 >= x1; j2--, i2++) {
                                    if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

                                    } else {
                                        tabla[j2][i2] = "relleno";
                                        pasa = true;
                                    }
                                }
                            }
                            tabla[x][y] = "relleno";
                            tabla[x1][y1] = reina;
                            pasa = true;
                        }
                    }
                    if (pasa == false) {
                        //JOptionPane.showMessageDialog(null, "movimiento invalido");
                    } else {
                        //JOptionPane.showMessageDialog(null, "movimiento hecho");
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "tienes que pasar por encima de la ficha");
                }
            } else {
                //JOptionPane.showMessageDialog(null, "ficha inesistente");
                pasa = false;
            }

            if (pasa == false) {
                break;
            }

        }
        return pasa;
    }
    int contar = 0;
    int x = 0, y = 0, x1 = 0, y1 = 0, rojas, negras;

    @Override

    public void actionPerformed(ActionEvent e) {
        System.out.println("presionado");
        for (int i = 0; i < boton[0].length; i++) {

            for (int j = 0; j < boton.length; j++) {
                if (e.getSource() == boton[i][j]) {
                    if (verificar_exitencia_de_ficha(color, i, j)) {
                        x = i;
                        y = j;
                        contar++;
                        System.out.println(contar);
                    } else if (contar == 1) {

                        if (jugar(color, x, y, i, j)) {
                            System.out.println("jugo");
                            tablero.Ponerficha();
                            CambioTurno();
                            Turno();

                        } else {
                        }
                        contar--;
                    }
                }
            }
        }

    }

    public TabFichas getTablero() {
        return tablero;
    }

    public char getColor() {
        return color;
    }

    public void Turno() {

        if (color == 'B') {

            vm.getJugador1().setForeground(new Color(243, 141, 67));

            vm.getJugador2().setForeground(Color.black);

        } else if (color == 'N') {

            vm.getJugador2().setForeground(new Color(243, 141, 67));

            vm.getJugador1().setForeground(Color.black);

        }
    }

    public void setColor(char color) {
        this.color = color;
    }

    public VistaMuertes getVm() {
        return vm;
    }
}
