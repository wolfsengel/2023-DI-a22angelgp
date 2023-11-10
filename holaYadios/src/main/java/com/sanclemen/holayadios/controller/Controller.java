package com.sanclemen.holayadios.controller;

import com.sanclemen.holayadios.FormEvent;
import com.sanclemen.holayadios.model.*;

public class Controller {
// Garda unha referencia á base de datos

    private Database db = new Database();

    public void addPerson(FormEvent ev) {

        int id = ev.getId();
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmploymentCategory();
        AgeCategory ageCategory;
        String gender = ev.getGenderCategory;
        Gender genderCategory;

        String taxId = ev.gettaxId;
        boolean usCitizen = ev.getCitizenship;

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
            case "employed" ->
                EmploymentCategory.EMPLOYED;
            case "umemployed" ->
                EmploymentCategory.UNEMPLOYED;
            case "selfemployed" ->
                EmploymentCategory.SELFEMPLOYED;
            default ->
                EmploymentCategory.OTHER;
        };

        genderCategory = switch (gender) {
            case "male" ->
                Gender.MALE;
            case "female" ->
                Gender.FEMALE;
            default ->
                Gender.OTHER;
        };

        Person person = new Person(id, name, occupation, ageCategory, empCategory, taxId, usCitizen, genderCategory);

        db.addPerson(person);
    }
}
