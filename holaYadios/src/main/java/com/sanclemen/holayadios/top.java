/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author a22angelgp
 */
public class top extends JPanel {

    JButton holabutton;
    JButton adiosbutton;
    StringListener stringListener;

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton == holabutton) {
                if (stringListener != null) {
                    StringEvent se = new StringEvent(this, holabutton.getText() + "\n");
                    stringListener.textEmited(se);
                }
            } else if (clickedButton == adiosbutton) {
                if (stringListener != null) {
                    StringEvent se2 = new StringEvent(this, adiosbutton.getText() + "\n");
                    stringListener.textEmited(se2);
                }
            }
        }
    };

    top() {
        holabutton = new JButton("Hola");
        adiosbutton = new JButton("Adios");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        holabutton.addActionListener(al);
        adiosbutton.addActionListener(al);
        add(holabutton);
        add(adiosbutton);
    }

    public JButton getHolabutton() {
        return holabutton;
    }

    public void setHolabutton(JButton holabutton) {
        this.holabutton = holabutton;
    }

    public JButton getAdiosbutton() {
        return adiosbutton;
    }

    public void setAdiosbutton(JButton adiosbutton) {
        this.adiosbutton = adiosbutton;
    }

    public StringListener getStringListener() {
        return stringListener;
    }

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    public ActionListener getAl() {
        return al;
    }

    public void setAl(ActionListener al) {
        this.al = al;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

}
