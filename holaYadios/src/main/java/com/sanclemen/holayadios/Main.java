package com.sanclemen.holayadios;

import com.sanclemen.holayadios.controller.Controller;
import com.sanclemen.holayadios.model.Database;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private HolaYadios textPanel;
    private final top top;
    private final Formpanel formpanel;
    private final JButton aceptarButton;
    private TablePanel tablePanel;
    private Controller controller;
    private Database db;

    public Main() {
        super("Hola Mundo");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        textPanel = new HolaYadios();
        top = new top();
        top.setStringListener((StringEvent se) -> {
            textPanel.appendText(se.getText());
        });
        tablePanel = new TablePanel();

        formpanel = new Formpanel();
        formpanel.setVisible(false);

        controller = new Controller();
        db = controller.db;
        /*formpanel.setFormListener((FormEvent fe) -> {

            textPanel.appendText(fe.toString());

        });*/

        formpanel.setFormListener((FormEvent ev) -> {
            controller.addPerson(ev);
            tablePanel.setData(db.getPeople());
            tablePanel.refresh();
        });

        aceptarButton = new JButton("Aceptar");/*
        aceptarButton.addActionListener((ActionEvent arg0) -> {
            textPanel.appendText("\nAceptado");
        });*/

        add(formpanel, BorderLayout.WEST);
        add(top, BorderLayout.PAGE_START);
        add(tablePanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        MenuBarPanel bar = new MenuBarPanel(formpanel);
        setJMenuBar(bar);

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
