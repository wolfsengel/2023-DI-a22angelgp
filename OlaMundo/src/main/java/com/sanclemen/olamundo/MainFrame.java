package com.sanclemen.olamundo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JTextArea textArea;
    private JButton aceptarButton;

    public MainFrame() {
        super("Alan rum4n0");

        // Configure the layout manager
        setLayout(new BorderLayout());

        // Create the text area and button
        textArea = new JTextArea();
        aceptarButton = new JButton("Si");

        aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            int num = 1;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Boton pulsado " + num + " veces");
                num++;
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        JLabel etiqueta = new JLabel("Ángel GP");
        etiqueta.setFont(new Font("Arial", Font.ITALIC, 20));
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        etiqueta.setPreferredSize(new Dimension(300, 150));

        add(etiqueta, BorderLayout.PAGE_START);

        setSize(600, 400);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
