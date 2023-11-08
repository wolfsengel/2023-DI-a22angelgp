/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author a22angelgp
 */
public class MenuBarPanel extends JMenuBar {

    public MenuBarPanel(Formpanel formpanel) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        JMenuItem savePersonMenuItem = new JMenuItem("Save Person", KeyEvent.VK_S);
        savePersonMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        savePersonMenuItem.addActionListener((ActionEvent e) -> {
            //TODO: IMPLEMENT
        });

        JMenuItem loadPersonMenuItem = new JMenuItem("Load Person", KeyEvent.VK_P);
        loadPersonMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        loadPersonMenuItem.addActionListener((ActionEvent e) -> {
            //TODO: IMPLEMENT
        });

        fileMenu.add(savePersonMenuItem);
        fileMenu.add(loadPersonMenuItem);
        fileMenu.add(exitMenuItem);

        // VIEW MENU
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);

        JCheckBoxMenuItem personFormMenuItem = new JCheckBoxMenuItem("Person Form");
        personFormMenuItem.setMnemonic(KeyEvent.VK_P);
        personFormMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        personFormMenuItem.addActionListener((ActionEvent e) -> {
            formpanel.setVisible(personFormMenuItem.isSelected());
        });

        viewMenu.add(personFormMenuItem);

        add(fileMenu);
        add(viewMenu);

    }

}
