package com.sanclemen.holayadios;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Formpanel extends JPanel {

    JPanel panel;
    JLabel nameLabel;
    GridBagConstraints constraints;
    JTextField nameField;
    JLabel occupationLabel;
    JTextField occupationField;
    JLabel ageLabel;
    ListPanel ageField;
    JButton okButton;

    StringListener stringListener;

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton == okButton) {
                String nombre = nameField.getText();
                String trabajo = occupationField.getText();
                if (stringListener != null) {
                    StringEvent se = new StringEvent(this, "Nombre: " + nombre + " -> Trabajo: " + trabajo + "\n");
                    stringListener.textEmited(se);
                }

            }
        }
    };

    Formpanel() {
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();

        // Crear el borde con título
        setBorder(BorderFactory.createTitledBorder("Add person"));

        // Etiqueta y campo de texto para el nombre
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(13);

        // Etiqueta y campo de texto para la ocupación
        occupationLabel = new JLabel("Occupation:");
        occupationField = new JTextField(13);

        //Etiqueta y campo para la edad
        ageLabel = new JLabel("Age:");
        ageField = new ListPanel("Under 18", "18 to 65", "65 and over");

        // Botón "Ok"
        okButton = new JButton("Ok");
        okButton.addActionListener(al);

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

        //Agregar la etiqueta age y el campo de edad
        constraints.gridx = 0;
        constraints.gridy = 2;

        constraints.anchor = GridBagConstraints.NORTHEAST;
        panel.add(ageLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        panel.add(ageField, constraints);

        // Agregar el botón "Ok"
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, constraints);
        add(panel);
        // Hacer visible la ventana
        setVisible(true);
    }
}
