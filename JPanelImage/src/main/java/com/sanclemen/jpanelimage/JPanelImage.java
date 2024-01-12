package com.sanclemen.jpanelimage;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author a22angelgp
 */
public class JPanelImage extends JPanel implements Serializable {

    private ImaxeFondo imaxefondo;

    public ImaxeFondo getImaxefondo() {
        return imaxefondo;
    }

    public void setImaxefondo(ImaxeFondo imaxefondo) {
        this.imaxefondo = imaxefondo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imaxefondo != null) {
            if (imaxefondo.getFicheiroImaxe() != null && imaxefondo.getFicheiroImaxe().exists()) {
                ImageIcon imageIcon = new ImageIcon(imaxefondo.getFicheiroImaxe().getAbsolutePath());
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        }

    }

    public JPanelImage() {
    }

}
