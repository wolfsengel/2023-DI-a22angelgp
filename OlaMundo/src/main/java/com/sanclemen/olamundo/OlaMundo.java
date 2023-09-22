/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sanclemen.olamundo;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author a22angelgp
 */
public class OlaMundo {

    public static void main(String[] args) {
// Schedule a job for the event-dispatch thread:
// creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
// Crea un novo frame co título especificado
                JFrame frame = new JFrame("Ola Mundo!");
// Establece o tamaño
                frame.setSize(600, 500);
// Establece a funcionalidade ao cerrar o frame (pulsar X)
// saír do programa
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// Fai o frame visible (por defecto é invisible)
                frame.setVisible(true);
            }
        });
    }
}
