package com.airtribe.meditrack.entities;

import com.airtribe.meditrack.interfaces.Payable;

import static com.airtribe.meditrack.constants.Constants.TAX_RATE;

public class Bill implements Payable {
    private int billId;
    private Patient patient;
    private double amount;

    public Bill(int billId, Patient patient, double amount) {
        this.billId = billId;
        this.patient = patient;
        this.amount = amount;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double calculateTotal(){
        return this.amount + (this.amount * TAX_RATE);
    }
}
