/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RuletaApp extends JFrame implements ActionListener {

    private JButton[] casillas;
    private JButton btnGirar;
    private double saldo = 0.0;

    public RuletaApp() {
        setTitle("Ruleta Europea");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(13, 3));

        casillas = new JButton[37];
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new JButton(Integer.toString(i));
            casillas[i].addActionListener(this);
            add(casillas[i]);
        }

        btnGirar = new JButton("Girar Ruleta");
        btnGirar.addActionListener(this);
        add(btnGirar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnGirar) {
            int resultado = generarNumeroAleatorio();
            JOptionPane.showMessageDialog(this, "La ruleta ha caído en el número " + resultado);
            verificarGanador(resultado);
        } else {
            JButton casilla = (JButton) source;
            casilla.setEnabled(false);
            saldo += 0.10;
            JOptionPane.showMessageDialog(this, "Has seleccionado la casilla " + casilla.getText());
        }
    }

    private int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(37);
    }

    private void verificarGanador(int resultado) {
        if (resultado == 0) {
            JOptionPane.showMessageDialog(this, "No has ganado esta vez.");
        } else {
            for (JButton casilla : casillas) {
                int numeroSeleccionado = Integer.parseInt(casilla.getText());
                if (numeroSeleccionado == resultado) {
                    saldo += 3.6; // Ganancia de 36 veces el valor de la selección (0.10 x 36 = 3.6)
                    JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado en la casilla " + resultado);
                    casilla.setEnabled(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RuletaApp app = new RuletaApp();
            app.setVisible(true);
        });
    }
}
