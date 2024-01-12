package com.sanclemen.jpanelimage;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author a22angelgp
 */
public class ImaxeFondo implements Serializable {

    private File ficheiroImaxe;
    private float opacidade;

    public File getFicheiroImaxe() {
        return ficheiroImaxe;
    }

    public void setFicheiroImaxe(File ficheiroImaxe) {
        this.ficheiroImaxe = ficheiroImaxe;

    }

    public float getOpacidade() {
        return opacidade;
    }

    public void setOpacidade(float opacidade) {
        this.opacidade = opacidade;
    }

    public ImaxeFondo() {
    }

    public ImaxeFondo(File ficheiroImaxe, float opacidade) {
        this.ficheiroImaxe = ficheiroImaxe;
        this.opacidade = opacidade;
    }
}
