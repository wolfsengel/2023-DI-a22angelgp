package com.sanclemen.holayadios.controller;

import com.sanclemen.holayadios.FormEvent;
import com.sanclemen.holayadios.model.*;

public class Controller {

    private Database db = new Database();

    public void addPerson(FormEvent ev) {

        int id = ev.getId();
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        int empCat = ev.getEmployCategory();
        AgeCategory ageCategory;
        int gender = ev.getGender();
        Gender genderCategory;

        String taxId = ev.getTaxId();
        boolean usCitizen = ev.isUsCitizen();

        ageCategory = switch (ageCatId) {
            case 0 ->
                AgeCategory.CHILD;
            case 1 ->
                AgeCategory.ADULT;
            case 2 ->
                AgeCategory.SENIOR;
            default ->
                AgeCategory.ADULT;
        };
        EmploymentCategory empCategory;
        empCategory = switch (empCat) {
            case 0 ->
                EmploymentCategory.EMPLOYED;
            case 1 ->
                EmploymentCategory.UNEMPLOYED;
            case 2 ->
                EmploymentCategory.SELFEMPLOYED;
            default ->
                EmploymentCategory.OTHER;
        };

        genderCategory = switch (gender) {
            case 0 ->
                Gender.MALE;
            case 1 ->
                Gender.FEMALE;
            case 2 ->
                Gender.OTHER;
            default ->
                Gender.OTHER;
        };

        Person person = new Person(id, name, occupation, ageCategory, empCategory, taxId, usCitizen, genderCategory);
        db.addPerson(person);

    }
}
