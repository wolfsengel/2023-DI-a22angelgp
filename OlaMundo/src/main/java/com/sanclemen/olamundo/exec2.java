package com.sanclemen.olamundo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exec2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de CardLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel titleLabel = new JLabel("Título da Interface");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JButton previousButton = new JButton("Anterior");
        JButton firstButton = new JButton("Primeira");
        JButton secondButton = new JButton("Segunda");
        JButton thirdButton = new JButton("Terceira");
        JButton nextButton = new JButton("Seguinte");
        leftPanel.add(previousButton);
        leftPanel.add(firstButton);
        leftPanel.add(secondButton);
        leftPanel.add(thirdButton);
        leftPanel.add(nextButton);
        frame.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new CardLayout());
        centerPanel.add(new JPanel(), "Primeira");
        centerPanel.add(new JPanel(), "Segunda");
        centerPanel.add(new JPanel(), "Terceira");
        frame.add(centerPanel, BorderLayout.CENTER);

        JLabel footerLabel = new JLabel("Moloko Software");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(footerLabel, BorderLayout.SOUTH);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
                String command = e.getActionCommand();
                if ("Anterior".equals(command)) {
                    cardLayout.previous(centerPanel);
                } else if ("Primeira".equals(command)) {
                    cardLayout.show(centerPanel, "Primeira");
                } else if ("Segunda".equals(command)) {
                    cardLayout.show(centerPanel, "Segunda");
                } else if ("Terceira".equals(command)) {
                    cardLayout.show(centerPanel, "Terceira");
                } else if ("Seguinte".equals(command)) {
                    cardLayout.next(centerPanel);
                }
            }
        };
        previousButton.addActionListener(listener);
        firstButton.addActionListener(listener);
        secondButton.addActionListener(listener);
        thirdButton.addActionListener(listener);
        nextButton.addActionListener(listener);

        frame.setVisible(true);
    }
}
