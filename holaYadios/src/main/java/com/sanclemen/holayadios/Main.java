/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    private HolaYadios textPanel;
    private final top top;
    private Formpanel formpanel;
    private final JButton aceptarButton;
    boolean hola = false;
    String palabro = "a";

    public Main() {
        super("Ola Mundo!");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        textPanel = new HolaYadios();
        top = new top();
        top.holabutton.addActionListener((ActionEvent arg0) -> {
            hola = true;
        });

        top.adiosbutton.addActionListener((ActionEvent arg0) -> {
            hola = false;
        });

        formpanel = new Formpanel();

        formpanel.okButton.addActionListener((ActionEvent arg0) -> {
            String nombre = formpanel.nameField.getText();
            textPanel.appendText("Nombre: " + nombre + "\n");
            String trabajo = formpanel.occupationField.getText();
            textPanel.appendText("Trabajo: " + trabajo + "\n");
        });

        aceptarButton = new JButton("Aceptar");

        aceptarButton.addActionListener((ActionEvent arg0) -> {
            palabro = hola ? "Hola" : "Adios";
            textPanel.appendText(palabro + "\n");
        });
        add(formpanel, BorderLayout.WEST);
        add(top, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }

}
