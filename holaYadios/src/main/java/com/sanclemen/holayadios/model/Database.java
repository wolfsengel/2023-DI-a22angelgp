package com.sanclemen.holayadios.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
}
