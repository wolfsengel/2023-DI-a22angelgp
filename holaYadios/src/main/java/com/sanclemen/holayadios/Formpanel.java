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
    JLabel employedLabel;
    ComboPanel employedField;
    JLabel genderLabel;
    ComboPanel genderField;
    JLabel casillaLabel;
    JCheckBox casillaUS;
    boolean casillasus = false;
    JLabel taxLabel;
    JTextField taxField;
    JButton okButton;
    boolean agreedTerms = false;

    FormListener formListener;

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    //Controlador upload persona
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (agreedTerms) {

                FormEvent fe = new FormEvent(nameField.getText(),
                        occupationField.getText(),
                        ageField.listaCadenas.getSelectedIndex(),
                        employedField.comboBox.getSelectedIndex(),
                        taxField.getText(),
                        casillasus,
                        genderField.comboBox.getSelectedIndex(),
                        this
                );

                formListener.personEmited(fe);

                nameField.setText("");
                occupationField.setText("");
                taxField.setText("");

                /*
                String nombre = nameField.getText();
                int edad = ageField.listaCadenas.getSelectedIndex();
                String trabajo = occupationField.getText();
                String taxUS = casillasus ? " : " + taxField.getText() : "";
                String info = nombre + " : " + trabajo + " : " + edad + " : " + employedField.comboBox.getSelectedItem() + " : " + genderField.comboBox.getSelectedItem() + taxUS;
                StringEvent se = new StringEvent(this, info);
                stringListener.textEmited(se);
                 */
            }

        }
    };
    //fin de esto wacho

    ActionListener al2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            casillasus = !casillasus;
            taxField.setEnabled(casillasus);
            taxLabel.setEnabled(casillasus);

        }
    };

    Formpanel() {

        if (!agreedTerms) {
            JCheckBox chk = new JCheckBox("Acepto los terminos y condiciones");
            String msg = "Tenemos politicas de privacidad y tal";
            JButton btn = new JButton("Acepto");
            btn.setEnabled(false);
            ActionListener al3 = (ActionEvent ae) -> {
                btn.setEnabled(chk.isSelected());
            };
            ActionListener al4 = (ActionEvent ae) -> {
                Window window = SwingUtilities.getWindowAncestor((Component) ae.getSource());
                if (window != null) {
                    window.dispose();
                }
            };
            btn.addActionListener(al4);
            chk.addActionListener(al3);
            Object[] msgContent = {msg, chk, btn};
            JOptionPane.showOptionDialog(Formpanel.this, msgContent, "Terminos y condiciones?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            agreedTerms = chk.isSelected();
        }

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

        //Etiqueta y campo de employment
        employedLabel = new JLabel("Employment:");
        employedField = new ComboPanel("Employed", "Self-Employed", "Unemployed");

        //Etiqueta y campo de gender
        genderLabel = new JLabel("Gender:");
        genderField = new ComboPanel("Male", "Female", "Otros");

        //Etiqueta y campo de uscitizen
        casillaLabel = new JLabel("US Citizen:");
        casillaUS = new JCheckBox();
        casillaUS.addActionListener(al2);

        //Etiqueta y campo de uscitizen
        taxLabel = new JLabel("Tax ID:");
        taxField = new JTextField(13);
        taxField.setEnabled(false);
        taxLabel.setEnabled(false);

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

        //Agregar la etiqueta Employment y el campo del combobox
        constraints.gridx = 0;
        constraints.gridy = 3;

        constraints.anchor = GridBagConstraints.NORTHEAST;
        panel.add(employedLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        panel.add(employedField, constraints);

        //Agregar la etiqueta UScitizen y el campo del jcheckbox
        constraints.gridx = 0;
        constraints.gridy = 4;

        constraints.anchor = GridBagConstraints.NORTHEAST;
        panel.add(casillaLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        panel.add(casillaUS, constraints);

        //Agregar la etiqueta Tax ID y el campo del textfield
        constraints.gridx = 0;
        constraints.gridy = 5;

        constraints.anchor = GridBagConstraints.NORTHEAST;
        panel.add(taxLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        panel.add(taxField, constraints);

        //Agregar la etiqueta Tax ID y el campo del textfield
        constraints.gridx = 0;
        constraints.gridy = 6;

        constraints.anchor = GridBagConstraints.NORTHEAST;
        panel.add(genderLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        panel.add(genderField, constraints);

        // Agregar el botón "Ok"
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, constraints);
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }
}
