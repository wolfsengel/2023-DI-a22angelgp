package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorVisual {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Crear un nuevo frame
        JFrame frame = new JFrame("Sumar App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        // Crear componentes
        JLabel label = new JLabel("Resultado:");
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JButton sumarButton = new JButton("Sumar");

        // Agregar componentes al frame
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(textField1);
        contentPane.add(textField2);
        contentPane.add(sumarButton);
        contentPane.add(label);

        // Agregar ActionListener al botón
        sumarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener valores de las cajas de texto y sumarlos
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double resultado = num1 + num2;
                    // Mostrar el resultado en la etiqueta
                    label.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    label.setText("Error: Ingrese números válidos");
                }
            }
        });

        // Mostrar el frame
        frame.setVisible(true);
    }
}
