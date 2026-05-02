package com.airtribe.meditrack.entities;

public class Patient extends Person{

    private int age;
    private char gender;

    public Patient(int personId, String personName, char gender, int age) {
        super(personId, personName);
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public void display() {
        System.out.println("Patient name: "+this.personName);
    }
}
