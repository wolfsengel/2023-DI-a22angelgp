/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;

public class exec3 extends JFrame {

    public exec3() {

        // Configuración de la ventana principal
        setTitle("Add Person Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        // Crear el panel principal con GridBagLayout
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear el borde con título
        panel1.setBorder(BorderFactory.createTitledBorder("Add person"));

        // Etiqueta y campo de texto para el nombre
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(13);

        // Etiqueta y campo de texto para la ocupación
        JLabel occupationLabel = new JLabel("Occupation:");
        JTextField occupationField = new JTextField(13);

        // Botón "Ok"
        JButton okButton = new JButton("Ok");

        // Configuración de los componentes
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Agregar la etiqueta y el campo de nombre
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        panel.add(nameField, constraints);

        // Agregar la etiqueta y el campo de ocupación
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(occupationLabel, constraints);

        constraints.gridx = 1;
        panel.add(occupationField, constraints);

        // Agregar el botón "Ok"
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, constraints);

        // Agregar el panel al contenido de la ventana
        panel1.add(panel);
        add(panel1);
        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new exec3();
        });
    }
}
