package com.airtribe.meditrack.entities;

abstract public class Person {

    protected int personId;
    protected String personName;

    public Person(int personId, String personName){
        this.personId= personId;
        this.personName= personName;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    abstract public void display();
}
