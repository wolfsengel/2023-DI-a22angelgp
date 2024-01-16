/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JButtonColorado;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a22angelgp
 */
public class JButtonColorado extends JButton implements Serializable {

    private Color fondo;
    private Color letra;

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
        this.setBackground(fondo);
        repaint();
    }

    public Color getLetra() {
        return letra;
    }

    public void setLetra(Color letra) {
        this.letra = letra;
        this.setForeground(letra);
        repaint();
    }

    public JButtonColorado() {
    }

}
