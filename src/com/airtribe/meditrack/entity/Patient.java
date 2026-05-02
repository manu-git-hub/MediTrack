package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.PersonType;
import com.airtribe.meditrack.util.IdGenerator;

public class Patient extends Person implements Cloneable{

	private final String patientId;
	private boolean deleted;

	public Patient(String patientId, String name, String address, String phone, String email, int age) {
		super(name, address, phone, email, PersonType.PATIENT, age);

		if (patientId == null || patientId.isBlank()) {
			throw new IllegalArgumentException("Invalid patient ID");
		}

		this.patientId = patientId;
		this.deleted = false;
	}

	public Patient(String name, String address, String phone, String email, int age) {
		this(IdGenerator.generateForPatient(), name, address, phone, email, age);
	}

	public String getPatientId() {
		return patientId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void markDeleted() {
		this.deleted = true;
	}

	@Override
	public String toString() {
		return "Patient{" + "id='" + patientId + '\'' + ", name='" + getName() + '\'' + ", age=" + getAge() + ", deleted=" + deleted + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Patient))
			return false;
		Patient that = (Patient) o;
		return patientId.equals(that.patientId);
	}

	@Override
	public int hashCode() {
		return patientId.hashCode();
	}

	@Override
	public Patient clone() {
		try {
			return new Patient(
					this.getPatientId(),
					this.getName(),
					this.getAddress(),
					this.getPhone(),
					this.getEmail(),
					this.getAge()
			);
		} catch (Exception e) {
			throw new RuntimeException("Clone failed", e);
		}
	}
}