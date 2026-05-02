package com.airtribe.meditrack.entities;
//Immutable class- will have getters, no setter, private final fields,
public final class BillSummary {

    private final int billId;
    private final double totalAmount;

    public BillSummary(int billId, double totalAmount) {
        this.billId = billId;
        this.totalAmount = totalAmount;
    }

    public int getBillId() {
        return billId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "billId=" + billId +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
