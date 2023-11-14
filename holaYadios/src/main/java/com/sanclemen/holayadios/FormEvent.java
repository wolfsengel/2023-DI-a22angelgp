package com.sanclemen.holayadios;

import java.util.EventObject;

public class FormEvent extends EventObject {

    static int count = 0;
    int id;
    String name;
    String occupation;
    int ageCategory;
    int employCategory;
    String taxId;
    boolean usCitizen;
    int gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(String name, String occupation, int ageCategory, int employCategory, String taxId, boolean usCitizen, int gender, Object source) {
        super(source);
        this.id = count;
        FormEvent.setCount();
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

    public static void setCount() {
        FormEvent.count++;
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

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    public int getEmployCategory() {
        return employCategory;
    }

    public void setEmployCategory(int employCategory) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
