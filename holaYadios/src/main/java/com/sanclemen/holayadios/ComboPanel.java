package com.sanclemen.holayadios;

import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class ComboPanel extends JPanel {

    JComboBox comboBox;

    public ComboPanel(String val1, String val2, String val3) {

        String[] model = {val1, val2, val3};
        comboBox = new JComboBox(model);
        comboBox.setEditable(true);
        comboBox.setSelectedIndex(0);
        comboBox.setVisible(true);
        add(comboBox);
    }
}
