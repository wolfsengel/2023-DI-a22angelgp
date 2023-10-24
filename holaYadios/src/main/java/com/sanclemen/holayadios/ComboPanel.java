package com.sanclemen.holayadios;

import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class ComboPanel extends JPanel {

    JComboBox comboBox;

    public ComboPanel() {

        String[] model = {"Employed", "Self-Employed", "Unemployed"};
        comboBox = new JComboBox(model);
        comboBox.setEditable(true);
        comboBox.setSelectedIndex(0);
        comboBox.setVisible(true);
        add(comboBox);
    }
}
