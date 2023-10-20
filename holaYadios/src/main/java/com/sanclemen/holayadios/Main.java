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
    private final Formpanel formpanel;
    //test
    private final ListPanel listpanel;
    private final JButton aceptarButton;

    public Main() {
        super("Ola Mundo!");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        textPanel = new HolaYadios();
        top = new top();
        top.setStringListener((StringEvent se) -> {
            textPanel.appendText(se.getText());
        });

        //test
        listpanel = new ListPanel();

        formpanel = new Formpanel();
        formpanel.setStringListener((StringEvent se) -> {
            textPanel.appendText(se.getText());
        });
        aceptarButton = new JButton("Aceptar");

        aceptarButton.addActionListener((ActionEvent arg0) -> {
            textPanel.appendText("\nAceptado");
        });
        //test
        formpanel.add(listpanel);
        add(formpanel, BorderLayout.WEST);
        add(top, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }

}
