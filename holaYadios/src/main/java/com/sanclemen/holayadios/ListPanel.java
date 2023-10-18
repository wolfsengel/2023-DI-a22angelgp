/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListPanel extends JPanel {

    private JList<String> listaCadenas;
    private DefaultListModel<String> listModel;
    private JTextField textField;
    private JButton btnAgregar;
    private JButton btnBorrar;

    public ListPanel() {
        listModel = new DefaultListModel<>();
        listaCadenas = new JList<>(listModel);
        listaCadenas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCadenas.setSelectedIndex(0);

        textField = new JTextField(20);
        btnAgregar = new JButton("Añadir");
        btnBorrar = new JButton("Borrar");
        btnBorrar.setEnabled(false);

        setLayout(new BorderLayout());
        add(new JScrollPane(listaCadenas), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(btnAgregar);
        panel.add(textField);
        panel.add(btnBorrar);
        add(panel, BorderLayout.SOUTH);

        // Manejar eventos del botón "Añadir"
        btnAgregar.addActionListener((ActionEvent e) -> {
            String nuevaCadena = textField.getText();
            if (!nuevaCadena.isEmpty()) {
                int selectedIndex = listaCadenas.getSelectedIndex();
                listModel.add(selectedIndex + 1, nuevaCadena);
                textField.setText("");
                listaCadenas.setSelectedIndex(selectedIndex + 1);
            }
        });

        // Manejar eventos del botón "Borrar"
        btnBorrar.addActionListener((ActionEvent e) -> {
            int selectedIndex = listaCadenas.getSelectedIndex();
            if (selectedIndex >= 0) {
                listModel.remove(selectedIndex);
                if (listModel.isEmpty()) {
                    btnBorrar.setEnabled(false);
                } else {
                    if (selectedIndex == listModel.size()) {
                        listaCadenas.setSelectedIndex(selectedIndex - 1);
                    } else {
                        listaCadenas.setSelectedIndex(selectedIndex);
                    }
                }
            }
        });

        // Manejar eventos del campo de texto
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btnAgregar.setEnabled(!textField.getText().isEmpty());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                btnAgregar.setEnabled(!textField.getText().isEmpty());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es necesario en este caso
            }
        });

        // Manejar eventos de selección en la lista
        listaCadenas.addListSelectionListener((ListSelectionEvent e) -> {
            btnBorrar.setEnabled(!listModel.isEmpty());
        });
    }
}
