package com.sanclemen.olamundo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class CodigoPostalSimulator extends JFrame {

    public CodigoPostalSimulator() {
        setTitle("Codigo Postal Epico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 100);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2)); // 1 fila, 2 columnas

        JFormattedTextField codPos = new JFormattedTextField(createFormatter("#####"));
        codPos.setColumns(10); // Establece el ancho del campo de texto
        panel.add(codPos);

        JButton test = new JButton("test");
        panel.add(test);

        add(panel);

        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigoPostal = codPos.getText();
                if (codigoPostal.matches("\\d{5}")) {
                    // El código postal tiene el formato correcto
                    JOptionPane.showMessageDialog(CodigoPostalSimulator.this, "Código postal válido: " + codigoPostal, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // El código postal no tiene el formato correcto
                    JOptionPane.showMessageDialog(CodigoPostalSimulator.this, "Código postal no válido. Debe tener 5 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CodigoPostalSimulator();
        });
    }
}
