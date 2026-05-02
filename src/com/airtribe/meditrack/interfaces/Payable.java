package com.airtribe.meditrack.interfaces;

public interface Payable {

    public double calculateTotal();
    default public void initiatingPayment(){
        System.out.println("Payment Processing Started");
    }

}
