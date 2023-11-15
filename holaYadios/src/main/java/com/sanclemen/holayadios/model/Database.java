package com.sanclemen.holayadios.model;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private List<Person> people;

    public Database() {
        people = new LinkedList();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
// Para evitar que se modifique a lista devolta
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.close();
        fos.close();
    }

    public void loadFromFile(File file) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            people.clear();
            people.addAll((LinkedList<Person>) ois.readObject());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        fis.close();
        ois.close();
    }
}
