package com.sanclemen.holayadios;

import com.sanclemen.holayadios.controller.Controller;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author a22angelgp
 */
public class MenuBarPanel extends JMenuBar {

    public MenuBarPanel(Formpanel formpanel, JFileChooser fileChooser, Controller controller, TablePanel tablePanel) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .per", "per");
        fileChooser.setFileFilter(filter);

        JMenuItem savePersonMenuItem = new JMenuItem("Save Person", KeyEvent.VK_S);
        savePersonMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        savePersonMenuItem.addActionListener((ActionEvent e) -> {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    controller.saveToFile(fileChooser.getSelectedFile());
                } catch (IOException exx) {
                    exx.printStackTrace();  // Manejo de errores básico, imprime la traza de la excepción
                }
            }
        });

        JMenuItem loadPersonMenuItem = new JMenuItem("Load Person", KeyEvent.VK_P);
        loadPersonMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        loadPersonMenuItem.addActionListener((ActionEvent e) -> {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    controller.loadFromFile(fileChooser.getSelectedFile());
                    tablePanel.refresh();
                } catch (IOException ex) {
                    ex.printStackTrace();  // Manejo de errores básico, imprime la traza de la excepción
                }
            }
        });

        fileMenu.add(savePersonMenuItem);
        fileMenu.add(loadPersonMenuItem);
        fileMenu.add(exitMenuItem);

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
