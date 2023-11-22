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
    private final Database db;
    private final JFileChooser fileChooser;

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

        fileChooser = new JFileChooser();

        controller = new Controller();
        db = controller.db;
        tablePanel.setData(db.getPeople());
        /*formpanel.setFormListener((FormEvent fe) -> {

            textPanel.appendText(fe.toString());

        });*/

        formpanel.setFormListener((FormEvent ev) -> {
            controller.addPerson(ev);
            tablePanel.refresh();
        });

        tablePanel.setPersonTableListener((int row) -> {
            controller.removePerson(row);
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

        MenuBarPanel bar = new MenuBarPanel(formpanel, fileChooser, controller, tablePanel);
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
