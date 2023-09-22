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
                MainFrame mf = new MainFrame();
            }
        });
    }
}
