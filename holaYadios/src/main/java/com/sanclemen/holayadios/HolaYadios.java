/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sanclemen.holayadios;

import java.awt.*;
import javax.swing.*;

public class HolaYadios extends JPanel {

    private JTextArea textArea;

    public HolaYadios() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        textArea.append(text);
    }
}
