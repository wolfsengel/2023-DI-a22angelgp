package com.sanclemen.jpanelimage;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a22angelgp
 */
public class JButtonPersonal extends JButton implements Serializable {

    private Color colorincho;
    private Color colorinColorado;

    public Color getColorincho() {
        return colorincho;
    }

    public void setColorincho(Color colorincho) {
        this.colorincho = colorincho;
        this.setBackground(colorincho);
        repaint();
    }

    public Color getColorinColorado() {
        return colorinColorado;
    }

    public void setColorinColorado(Color colorinColorado) {
        this.colorinColorado = colorinColorado;
        this.setForeground(colorinColorado);
        repaint();
    }

    public JButtonPersonal() {
    }

}
