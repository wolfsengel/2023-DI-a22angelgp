/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author a22angelgp
 */
public class top extends JPanel {

    JButton holabutton;
    JButton adiosbutton;

    top() {
        holabutton = new JButton("Hola");
        adiosbutton = new JButton("Adios");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(holabutton);
        add(adiosbutton);
    }

}
