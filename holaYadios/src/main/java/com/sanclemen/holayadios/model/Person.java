package com.sanclemen.holayadios.model;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1234L;

    static int count = 0;
    int id;
    String name;
    String occupation;
    AgeCategory ageCategory;
    EmploymentCategory employCategory;
    String taxId;
    boolean usCitizen;
    Gender gender;

    public Person(int id, String name, String occupation, AgeCategory ageCategory, EmploymentCategory employCategory, String taxId, boolean usCitizen, Gender gender) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employCategory = employCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmployCategory() {
        return employCategory;
    }

    public void setEmployCategory(EmploymentCategory employCategory) {
        this.employCategory = employCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
