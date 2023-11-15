/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanclemen.holayadios.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> personList;
    private String[] columnNames = {"ID", "Name", "Occupation", "Age Category",
        "Employment Category", "US Citizen", "Tax ID", "Gender"};

    public PersonTableModel() {
    }

    public void setData(List<Person> personList) {
        this.personList = personList;
        // Notify the table that the data has changed, so it can be redrawn
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        // The number of rows is equal to the number of persons in the list
        return personList == null ? 0 : personList.size();
    }

    @Override
    public int getColumnCount() {
        // The number of columns is equal to the length of the columnNames array
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (personList == null || personList.isEmpty() || row < 0 || row >= getRowCount()) {
            return null;
        }

        Person person = personList.get(row);

        // Now, based on the column index, return the corresponding value from the Person object
        switch (column) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getEmployCategory();
            case 5:
                return person.isUsCitizen();
            case 6:
                return person.getTaxId();
            case 7:
                return person.getGender();
            default:
                return null; // Return null for unknown columns
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column < 0 || column >= getColumnCount()) {
            throw new ArrayIndexOutOfBoundsException(column);
        } else {
            return columnNames[column];
        }
    }
}
