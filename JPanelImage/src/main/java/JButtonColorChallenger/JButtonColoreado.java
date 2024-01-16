package JButtonColorChallenger;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a22angelgp
 */
public class JButtonColoreado extends JButton implements Serializable {

    private JButtonColorado buttonC;

    public JButtonColoreado() {
    }

    public JButtonColorado getButtonC() {
        return buttonC;
    }

    public void setButtonC(JButtonColorado buttonC) {
        this.buttonC = buttonC;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buttonC != null) {
            if (buttonC.getFondo() != null) {
                this.setBackground(buttonC.getFondo());
            }
            if (buttonC.getLetra() != null) {
                this.setForeground(buttonC.getLetra());
            }
            repaint();
        }

    }

}
