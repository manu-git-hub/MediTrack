package com.airtribe.meditrack.entity;

public final class BillSummary {

	private final String billId;
	private final String appointmentId;
	private final double consultationFee;
	private final double taxAmount;
	private final double totalAmount;

	public BillSummary(String billId, String appointmentId, double consultationFee, double taxAmount, double totalAmount) {

		if (billId == null || billId.isBlank())
			throw new IllegalArgumentException("Invalid bill ID");

		if (appointmentId == null || appointmentId.isBlank())
			throw new IllegalArgumentException("Invalid appointment ID");

		this.billId = billId;
		this.appointmentId = appointmentId;
		this.consultationFee = consultationFee;
		this.taxAmount = taxAmount;
		this.totalAmount = totalAmount;
	}

	public String getBillId() {
		return billId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public String toString() {
		return "BillSummary{" + "billId='" + billId + '\'' + ", appointmentId='" + appointmentId + '\'' + ", fee=" + consultationFee + ", tax=" + taxAmount + ", total=" + totalAmount + '}';
	}
}