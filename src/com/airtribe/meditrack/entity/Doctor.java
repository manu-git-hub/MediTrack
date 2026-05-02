package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.PersonType;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.util.IdGenerator;

public class Doctor extends Person {

	private final String doctorId;
	private final Specialization specialization;
	private double consultationFee;
	private boolean deleted;

	public Doctor(String doctorId, String name, String address, String phone, String email, int age, Specialization specialization, double consultationFee) {

		super(name, address, phone, email, PersonType.DOCTOR, age);

		if (doctorId == null || doctorId.isBlank()) {
			throw new IllegalArgumentException("Invalid doctor ID");
		}

		if (specialization == null) {
			throw new IllegalArgumentException("Specialization cannot be null");
		}

		if (consultationFee < 0) {
			throw new IllegalArgumentException("Fee cannot be negative");
		}

		this.doctorId = doctorId;
		this.specialization = specialization;
		this.consultationFee = consultationFee;
		this.deleted = false;
	}

	public Doctor(String name, String address, String phone, String email, int age, Specialization specialization, double consultationFee) {

		this(IdGenerator.generateForDoctor(), name, address, phone, email, age, specialization, consultationFee);
	}

	public String getDoctorId() {
		return doctorId;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void updateConsultationFee(double consultationFee) {
		if (consultationFee < 0) {
			throw new IllegalArgumentException("Fee cannot be negative");
		}
		this.consultationFee = consultationFee;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void markDeleted() {
		this.deleted = true;
	}

	@Override
	public String toString() {
		return "Doctor{" + "id='" + doctorId + '\'' + ", name='" + getName() + '\'' + ", specialization=" + specialization + ", fee=" + consultationFee + ", deleted=" + deleted + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Doctor))
			return false;
		Doctor doctor = (Doctor) o;
		return doctorId.equals(doctor.doctorId);
	}

	@Override
	public int hashCode() {
		return doctorId.hashCode();
	}
}