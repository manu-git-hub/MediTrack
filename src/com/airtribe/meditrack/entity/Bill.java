package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.util.Configuration;
import com.airtribe.meditrack.util.IdGenerator;

public class Bill {

	private final String billId;
	private final String appointmentId;

	private double consultationFee;
	private double taxAmount;
	private double totalAmount;

	private BillSummary summary;

	public Bill(String appointmentId, double consultationFee) {

		if (appointmentId == null || appointmentId.isBlank())
			throw new IllegalArgumentException("Invalid appointment ID");

		if (consultationFee < 0)
			throw new IllegalArgumentException("Invalid consultation fee");

		this.billId = IdGenerator.generateGeneric("bl.");
		this.appointmentId = appointmentId;
		this.consultationFee = consultationFee;

		calculate();
	}

	private void calculate() {
		this.taxAmount = consultationFee * new Configuration().getPropertyAsInt("billing.taxrate");
		this.totalAmount = consultationFee + taxAmount;

		this.summary = new BillSummary(billId, appointmentId, consultationFee, taxAmount, totalAmount);
	}

	public BillSummary getSummary() {
		return summary;
	}

	public String getBillId() {
		return billId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	@Override
	public String toString() {
		return summary.toString();
	}
}