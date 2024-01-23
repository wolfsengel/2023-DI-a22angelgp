package JButtonColorChallenger;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author a22angelgp
 */
public class JButtonColorado implements Serializable {

    private Color fondo = Color.PINK;
    private Color letra = Color.PINK;

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

}
