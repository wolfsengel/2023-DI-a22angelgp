/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class ComboPanel extends JPanel {

    private final JList<String> listaCadenas;
    private final DefaultListModel<String> listModel;

    public ComboPanel(String elemen1, String elemen2, String elemen3) {

        listModel = new DefaultListModel<>();
        listaCadenas = new JList<>(listModel);

        listaCadenas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listModel.addElement(elemen1);
        listModel.addElement(elemen2);
        listModel.addElement(elemen3);

        listaCadenas.setSelectedIndex(0);

        JComboBox comboBox = new JComboBox((ComboBoxModel) listaCadenas);

        comboBox.isEditable();

    }

}
