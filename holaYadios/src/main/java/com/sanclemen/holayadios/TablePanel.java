package com.sanclemen.holayadios;

import com.sanclemen.holayadios.model.Person;
import com.sanclemen.holayadios.model.PersonTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable table;
    private PersonTableModel personTableModel;
    private JPopupMenu popupMenu;
    private PersonTableListener personTableListener;
    public void setPersonTableListener(PersonTableListener personTableListener) {
        this.personTableListener = personTableListener;
    }

    public TablePanel() {
        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);
        popupMenu = new JPopupMenu();

        JMenuItem deleteItem = new JMenuItem("Delete Row");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (personTableListener != null) {
                    personTableListener.rowDeleted(selectedRow);
                    personTableModel.fireTableRowsDeleted(selectedRow, selectedRow);
                }
            }
        });

        popupMenu.add(deleteItem);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    public void setData(List<Person> personList) {
        personTableModel.setData(personList);
    }

    public void refresh() {
        personTableModel.fireTableDataChanged();
    }
}
