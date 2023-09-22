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
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Ola Mundo!");
                frame.setSize(600, 500);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                //frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                //frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
