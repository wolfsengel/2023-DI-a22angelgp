package com.sanclemen.holayadios;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {

    final JList<String> listaCadenas;
    final DefaultListModel<String> listModel;

    public ListPanel(String elemen1, String elemen2, String elemen3) {
        listModel = new DefaultListModel<>();
        listaCadenas = new JList<>(listModel);
        listaCadenas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCadenas.setSelectedIndex(0);

        listModel.addElement(elemen1);
        listModel.addElement(elemen2);
        listModel.addElement(elemen3);

        listaCadenas.setSelectedIndex(0);
        JScrollPane scrollPane = new JScrollPane(listaCadenas);
        scrollPane.setPreferredSize(new Dimension(120, 75));

        add(scrollPane);

    }

}
