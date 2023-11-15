/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios;

import com.sanclemen.holayadios.model.Person;
import com.sanclemen.holayadios.model.PersonTableModel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TablePanel extends JPanel {

    private JTable table;
    private PersonTableModel personTableModel;

    public TablePanel() {
        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    public void setData(List<Person> personList) {
        personTableModel.setData(personList);
    }
// para notificar á vista de que o modelo de datos cambiou

    public void refresh() {
        personTableModel.fireTableDataChanged();
    }
}
