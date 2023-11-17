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
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(people);
        }
    }

    public void loadFromFile(File file) throws IOException {

        ObjectInputStream ois;
        try (FileInputStream fis = new FileInputStream(file)) {
            ois = new ObjectInputStream(fis);
            try {
                people.clear();
                LinkedList<Person> list = (LinkedList<Person>) ois.readObject();
                people.addAll(list);
                Person.count = list.get(list.size() - 1).getId() + 1;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        ois.close();
    }
}
