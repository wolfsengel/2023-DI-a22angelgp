/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JButtonColorChallenger;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author a22angelgp
 */
public class JButtonColorado implements Serializable {

    private Color fondo;
    private Color letra;

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    public Color getLetra() {
        return letra;
    }

    public void setLetra(Color letra) {
        this.letra = letra;
    }

    public JButtonColorado(Color fondo, Color letra) {
        this.fondo = fondo;
        this.letra = letra;
    }

    public JButtonColorado() {
    }

}
