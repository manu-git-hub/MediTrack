package com.airtribe.meditrack.entity;

import java.time.LocalDateTime;

import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.util.IdGenerator;

public class Appointment implements Cloneable{

	private final String appointmentId;
	private final String patientId;
	private final String doctorId;
	private final LocalDateTime appointmentTime;

	private AppointmentStatus status;

	public Appointment(String appointmentId, String patientId, String doctorId, LocalDateTime appointmentTime, AppointmentStatus status) {

		if (appointmentId == null || appointmentId.isBlank()) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		if (patientId == null || patientId.isBlank()) {
			throw new IllegalArgumentException("Invalid patient ID");
		}
		if (doctorId == null || doctorId.isBlank()) {
			throw new IllegalArgumentException("Invalid doctor ID");
		}
		if (appointmentTime == null) {
			throw new IllegalArgumentException("Appointment time cannot be null");
		}
		if (status == null) {
			throw new IllegalArgumentException("Status cannot be null");
		}

		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public Appointment(String patientId, String doctorId, LocalDateTime appointmentTime) {
		this(IdGenerator.generateForAppointment(), patientId, doctorId, appointmentTime, AppointmentStatus.CONFIRMED);
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void cancel() {
		if (this.status == AppointmentStatus.CANCELLED) {
			throw new IllegalStateException("Appointment already cancelled");
		}
		this.status = AppointmentStatus.CANCELLED;
	}

	@Override
	public String toString() {
		return "Appointment{" + "id='" + appointmentId + '\'' + ", patientId='" + patientId + '\'' + ", doctorId='" + doctorId + '\'' + ", time=" + appointmentTime + ", status=" + status + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Appointment))
			return false;
		Appointment that = (Appointment) o;
		return appointmentId.equals(that.appointmentId);
	}

	@Override
	public int hashCode() {
		return appointmentId.hashCode();
	}

	@Override
	public Appointment clone() {
		try {
			return new Appointment(
					this.getAppointmentId(),
					this.getPatientId(),
					this.getDoctorId(),
					this.getAppointmentTime(),
					this.getStatus()
			);
		} catch (Exception e) {
			throw new RuntimeException("Clone failed", e);
		}
	}
}
