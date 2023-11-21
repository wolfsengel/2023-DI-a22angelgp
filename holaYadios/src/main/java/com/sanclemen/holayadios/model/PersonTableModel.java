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
        fireTableDataChanged();
    }
    public void removePerson(int rowIndex) {
        this.personList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public int getRowCount() {
        // The number of rows is equal to the number of persons in the list
        return personList == null ? 0 : personList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (personList == null || personList.isEmpty() || row < 0 || row >= getRowCount()) {
            return null;
        }

        Person person = personList.get(row);

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
                return null;
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
