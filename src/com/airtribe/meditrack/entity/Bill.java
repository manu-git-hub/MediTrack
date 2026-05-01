package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.interfaces.Payable;

public class Bill implements Payable {
    private int billId;
    private Appointment appointment;
    private double fee;

    public Bill(int billId, Appointment appointment, double fee) {
        this.billId = billId;
        this.appointment = appointment;
        this.fee = fee;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double calculateTotal() {
        return fee + (fee * Constants.TAX_RATE);
    }

    public BillSummary generateSummary() {
        return new BillSummary (billId, appointment.getPatient().getName(), calculateTotal());
    }
}
