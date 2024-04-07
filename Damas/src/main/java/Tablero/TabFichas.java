/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tablero;

import Abstraccion.IFicha;
import Fichas.FichaBlanca;
import Fichas.FichaBlancaR;
import Fichas.FichaNegra;
import Fichas.FichaNegraR;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TabFichas {

    private String Tabficha[][] = new String[8][8];
    private Tablero tablero;

    FichaNegra Negra = new FichaNegra();
    FichaNegra Negrar = new FichaNegra();
    FichaBlanca Blanca = new FichaBlanca();
    FichaBlanca Blancar = new FichaBlanca();
    IFicha Negraclon = null;
    IFicha Blancaclon = null;

    public TabFichas() {
        tablero = Tablero.getInstance();
        iniciar();
        Ponerficha();
    }

    public void iniciar() {
        for (int i = 0; i < Tabficha.length; i++) {
            for (int j = 0; j < Tabficha[0].length; j++) {
                if (j % 2 == 0 && i == 1) {
                    Tabficha[i][j] = "n";
                } else if (j % 2 != 0 && i % 2 == 0 && i < 3) {
                    Tabficha[i][j] = "n";
                } else if (j % 2 != 0 && i == 6) {
                    Tabficha[i][j] = "b";
                } else if (j % 2 == 0 && i % 2 != 0 && i > 4) {
                    Tabficha[i][j] = "b";
                } else {
                    Tabficha[i][j] = "relleno";
                }
            }

        }
    }

    public void Ponerficha() {


        posibilidad_reina();
        for (int i = 0; i < Tabficha.length; i++) {
            for (int j = 0; j < Tabficha[0].length; j++) {
                if (Tabficha[i][j] == "n") {
                    Negra.setboton(tablero.getboton(i, j));
                    Negra.setFichan(new ImageIcon("./imagenes/FichaNegra.png"));
                    Negraclon = Negra.clonar();

                    Negraclon.setboton(tablero.getboton(i, j));
                    Negraclon.setFichan(new ImageIcon("./imagenes/FichaNegra.png"));

                } else if (Tabficha[i][j] == "b") {
                    Blanca.setboton(tablero.getboton(i, j));
                    Blanca.setFichan(new ImageIcon("./imagenes/FichaBlanca.png"));
                    Blancaclon = Blanca.clonar();

                    Blancaclon.setboton(tablero.getboton(i, j));

                } else if (Tabficha[i][j] == "relleno") {
                    if (j % 2 == 0 && i % 2 == 0) {

                        tablero.getboton(i, j).setIcon(new ImageIcon("./imagenes/FondoNegro.png"));
                    } else if (j % 2 != 0 && i % 2 != 0) {

                        tablero.getboton(i, j).setIcon(new ImageIcon("./imagenes/FondoNegro.png"));
                    } else {
                        tablero.getboton(i, j).setIcon(new ImageIcon("./imagenes/FondoBlanco.png"));
                    }
                } else if (Tabficha[i][j] == "rn") {
                    FichaNegraR fnr = new FichaNegraR(Negrar);
                    fnr.CambioReina();
                    Negrar.setboton(tablero.getboton(i, j));
                } else if (Tabficha[i][j] == "rb") {
                    FichaBlancaR fbr = new FichaBlancaR(Blancar);
                    fbr.CambioReina();
                    Blancar.setboton(tablero.getboton(i, j));
                }
            }
        }
    }

    public void posibilidad_reina() {
        for (int j = 0; j < Tabficha[0].length; j++) {
            if (Tabficha[7][j] == "n") {

                Tabficha[7][j] = "rn";

            } else if (Tabficha[0][j] == "b") {
                Tabficha[0][j] = "rb";

            }
        }
    }

    public IFicha getNegraclon() {
        return Negraclon;
    }

    public IFicha getBlancaclon() {
        return Blancaclon;
    }

    public Tablero gettablero() {
        return this.tablero;
    }

    public String[][] getTabficha() {
        return Tabficha;
    }
}
