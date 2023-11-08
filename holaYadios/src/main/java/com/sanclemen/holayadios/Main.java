package com.sanclemen.holayadios;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    private HolaYadios textPanel;
    private final top top;
    private final Formpanel formpanel;
    private final JButton aceptarButton;

    public Main() {
        super("Hola Mundo");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        textPanel = new HolaYadios();
        top = new top();
        top.setStringListener((StringEvent se) -> {
            textPanel.appendText(se.getText());
        });

        formpanel = new Formpanel();
        formpanel.setStringListener((StringEvent se) -> {
            textPanel.appendText(se.getText());
        });
        formpanel.setVisible(false);

        aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener((ActionEvent arg0) -> {
            textPanel.appendText("\nAceptado");
        });

        add(formpanel, BorderLayout.WEST);
        add(top, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        MenuBarPanel bar = new MenuBarPanel(formpanel);
        setJMenuBar(bar);

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
