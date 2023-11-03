package com.sanclemen.holayadios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TermsCheck extends JOptionPane {

    JCheckBox casilla;
    JButton aceptarTerms;

    public TermsCheck() {

        casilla = new JCheckBox("I accept the Terms and Conditions");
        aceptarTerms = new JButton("Accept");
        aceptarTerms.setEnabled(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(casilla);
        panel.add(aceptarTerms);

        casilla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarTerms.setEnabled(casilla.isSelected());
            }
        });

        add(panel);
        setVisible(true);
    }
}
