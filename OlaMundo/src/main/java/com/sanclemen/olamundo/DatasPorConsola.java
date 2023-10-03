/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;

public class DatasPorConsola extends JFrame {

    private JFormattedTextField numeroField;
    private JFormattedTextField fechaField;

    public DatasPorConsola() {
        setTitle("Datas EPICAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel numeroLabel = new JLabel("Número:");
        numeroField = new JFormattedTextField(createNumberFormatter());
        numeroField.setText("" + 0); // Valor inicial
        JLabel fechaLabel = new JLabel("Fecha:");
        fechaField = new JFormattedTextField(createDateFormatter());
        fechaField.setValue("01/01/2023"); // Valor inicial

        JButton imprimirButton = new JButton("Imprimir valores");
        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirValores();
            }
        });

        add(numeroLabel);
        add(numeroField);
        add(fechaLabel);
        add(fechaField);
        add(imprimirButton);
    }

    private void imprimirValores() {
        System.out.println("Número: " + numeroField.getValue());
        System.out.println("Fecha: " + fechaField.getValue());
    }

    private MaskFormatter createNumberFormatter() {
        MaskFormatter formatter = null;

        try {
            formatter = new MaskFormatter("#####"); // Para números de 5 dígitos
        } catch (java.text.ParseException exc) {
            System.err.println("El formato es incorrecto: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    private MaskFormatter createDateFormatter() {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##/##/####"); // Para fechas (dd/mm/aaaa)
        } catch (java.text.ParseException exc) {
            System.err.println("El formato es incorrecto: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DatasPorConsola().setVisible(true);
        });
    }
}
