/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.olamundo;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class MainFrame extends JFrame {

    private JTextArea textArea;
    private JButton aceptarButton;

    public MainFrame() {
        super("Hola mundo");
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        aceptarButton = new JButton("Aceptar");
        add(textArea, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
