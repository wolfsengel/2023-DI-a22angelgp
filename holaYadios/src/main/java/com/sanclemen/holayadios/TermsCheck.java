package com.sanclemen.holayadios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class TermsCheck extends JPanel {

    JCheckBox casilla;
    JButton aceptarTerms;
    JTextField quest;

    public TermsCheck() {
        casilla = new JCheckBox("Accept");
        aceptarTerms = new JButton("Continuar");
        quest = new JTextField("Terms and Conditions are OKie-dOKie with you?");

        aceptarTerms.setEnabled(false);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                aceptarTerms.setEnabled(true);

            }
        };
        casilla.addActionListener(al);
        add(casilla);
        add(aceptarTerms);
        add(quest);
    }
}
