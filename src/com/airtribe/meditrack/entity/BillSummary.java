package com.airtribe.meditrack.entity;

public final class BillSummary {
    private final int billId;
    private final String patientName;
    private final double totalAmount;

    public BillSummary(int billId, String patientName, double totalAmount) {
        this.billId = billId;
        this.patientName = patientName;
        this.totalAmount = totalAmount;
    }
    @Override
    public String toString() {
        return "BillSummary{ID=" + billId + ", Patient='" + patientName + "', Total=$" + totalAmount + "}";
    }
}