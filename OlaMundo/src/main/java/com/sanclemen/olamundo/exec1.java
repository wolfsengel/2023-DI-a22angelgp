/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;

public class exec1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo de BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Título que ti queiras xd");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Botón " + i);
            leftPanel.add(button);
        }
        frame.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1));
        for (int i = 6; i <= 10; i++) {
            JButton button = new JButton("Botón " + i);
            rightPanel.add(button);
        }
        frame.add(rightPanel, BorderLayout.EAST);

        JTextArea textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JLabel footerLabel = new JLabel("Moloko Software");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(footerLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
