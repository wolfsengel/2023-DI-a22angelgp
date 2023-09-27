package com.sanclemen.olamundo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewFrame extends JFrame {

    private final JLabel label;
    private final JPanel panel;
    private final Color originalColor;
    private boolean colorChange = false;

    public NewFrame() {
        setTitle("Ejercicio de Botones y Eventos");
        setLayout(new FlowLayout());

        JButton closeButton = new JButton("Cerrar la aplicación");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton button1 = new JButton("Boton 1");
        JButton button2 = new JButton("Boton 2");
        JButton button3 = new JButton("Boton 3");

        label = new JLabel("Presiona un botón");
        panel = new JPanel();
        originalColor = panel.getBackground();

        button1.addActionListener(new ButtonListener("Boton 1"));
        button2.addActionListener(new ButtonListener("Boton 2"));
        button3.addActionListener(new ButtonListener("Boton 3"));

        button1.addMouseListener(new ButtonHover(button1));
        button2.addMouseListener(new ButtonHover(button2));
        button3.addMouseListener(new ButtonHover(button3));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleBackgroundColor();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetBackgroundColor();
            }
        });

        panel.setPreferredSize(new Dimension(1000, 1000));
        panel.add(label);

        add(closeButton);
        add(button1);
        add(button2);
        add(button3);
        add(panel);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void toggleBackgroundColor() {
        if (colorChange) {
            panel.setBackground(originalColor);
        } else {
            panel.setBackground(Color.YELLOW); // Cambia el color a amarillo
        }
        colorChange = !colorChange;
    }

    private void resetBackgroundColor() {
        panel.setBackground(originalColor);
        colorChange = false;
    }

    private class ButtonListener implements ActionListener {

        private final String buttonName;

        public ButtonListener(String name) {
            buttonName = name;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setTitle("Botón pulsado: " + buttonName);
        }
    }

    private class ButtonHover extends MouseAdapter {

        JButton boton;

        ButtonHover(JButton boton) {
            this.boton = boton;
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            boton.setBackground((Color.BLUE));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            boton.setBackground((Color.WHITE));
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NewFrame();
        });
    }
}
