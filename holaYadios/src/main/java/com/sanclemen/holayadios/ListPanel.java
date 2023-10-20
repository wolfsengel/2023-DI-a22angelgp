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
        btnAgregar = new JButton("Add");
        btnBorrar = new JButton("Erase");
        btnAgregar.setEnabled(false);

        listModel.addElement("Alan papichulo");
        listModel.addElement("Ivan el Sultan");
        listModel.addElement("Vladdy Daddy");

        listaCadenas.setSelectedIndex(0);

        setLayout(new BorderLayout());
        add(new JScrollPane(listaCadenas), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Usar BoxLayout para alinear los componentes horizontalmente

        panel.add(btnAgregar);
        panel.add(Box.createRigidArea(new Dimension(5, 0))); // Espacio rígido para separar los componentes
        panel.add(new JSeparator(SwingConstants.VERTICAL)); // Línea separadora vertical
        panel.add(Box.createRigidArea(new Dimension(5, 0))); // Más espacio rígido
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
