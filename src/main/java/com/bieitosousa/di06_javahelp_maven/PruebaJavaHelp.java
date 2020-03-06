/*
 * The MIT License
 *
 * Copyright 2020 bieito.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bieitosousa.di06_javahelp_maven;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author bieito
 */
public class PruebaJavaHelp {

    /**
     * Ventana secundaria
     */
    private JDialog secundaria;

    /**
     * Ventana principal
     */
    private JFrame principal;

    /**
     * Item de menú para la ayuda
     */
    private JMenuItem itemAyuda;

    /**
     * Boton que despliega la ventana secundaria
     */
    private JButton botonMuetraSecundaria;

    /**
     * Crea una instanacia de esta clase.
     *
     * @param args
     */


    /**
     * Crea las ventanas, pone la ayuda y visualiza la ventana principal.
     */
    public PruebaJavaHelp() {
        creaVentanaPrincipal();
       

        botonMuetraSecundaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secundaria.setVisible(true);
            }

        });

        ponLaAyuda();
        visualizaVentanaPrincipal();
    }

    /**
     * Con este nombre digo yo que visualizará la ventana principal.
     */
    private void visualizaVentanaPrincipal() {
        principal.pack();
        principal.setVisible(true);
        principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Hace que el item del menu y la pulsacion de F1 visualicen la ayuda.
     */
    private void ponLaAyuda() {
        try {
            Contenidos c = new Contenidos();
            HelpBroker hb = null;
            HelpSet helpset = null;
            if ((helpset = c.start()) != null) {
                if ((hb = c.help(helpset)) != null) {
                    hb.enableHelpOnButton(itemAyuda, "definicion", helpset);
                    hb.enableHelpKey(principal.getContentPane(), "ventana_principal", helpset);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ¿Quizás crea la ventana principal?
     */
    private void creaVentanaPrincipal() {
        principal = new JFrame("Ventana principal");
        JMenuBar menuBar = new JMenuBar();
        itemAyuda = new JMenuItem("Ayuda");
        menuBar.add(itemAyuda);
        botonMuetraSecundaria = new JButton("Pulsame");
        principal.setJMenuBar(menuBar);
        principal.getContentPane().setLayout(new FlowLayout());
    }
}
