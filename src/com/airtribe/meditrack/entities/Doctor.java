package com.airtribe.meditrack.entities;

import com.airtribe.meditrack.constants.Specialization;

public class Doctor extends Person{

    private Specialization specialization;
    private double consultationFee;
    private float yearsOfExperience;

    public Doctor(int personId, String personName, Specialization specialization, double consultationFee, float yearsOfExperience) {
        super(personId, personName);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void display() {
        System.out.println("Doctor: "+this.personName+" specialized in "+this.specialization);
    }
}
