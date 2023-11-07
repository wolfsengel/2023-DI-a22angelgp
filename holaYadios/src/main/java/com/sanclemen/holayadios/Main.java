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
        formpanel.setVisible(false); // Inicialmente, el formulario está oculto

        aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener((ActionEvent arg0) -> {
            textPanel.appendText("\nAceptado");
        });

        add(formpanel, BorderLayout.WEST);
        add(top, BorderLayout.PAGE_START);
        add(textPanel, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú "File"
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Opción "Exit" con atajo Ctrl+E
        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0); // Cierra la aplicación
        });

        fileMenu.add(exitMenuItem);

        // Menú "View"
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);

        // CheckBox "Person Form" con atajo Ctrl+P
        JCheckBoxMenuItem personFormMenuItem = new JCheckBoxMenuItem("Person Form");
        personFormMenuItem.setMnemonic(KeyEvent.VK_P);
        personFormMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        personFormMenuItem.addActionListener((ActionEvent e) -> {
            formpanel.setVisible(personFormMenuItem.isSelected());
        });

        viewMenu.add(personFormMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

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
