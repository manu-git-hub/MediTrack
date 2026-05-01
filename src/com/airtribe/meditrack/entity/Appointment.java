package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.Enum.AppointmentStatus;

import java.time.LocalDateTime;

public class Appointment implements Cloneable {
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private AppointmentStatus status;

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String date) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = date;
        this.status = AppointmentStatus.PENDING;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public Appointment clone() {
        try {
            return (Appointment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return " {ID=" + appointmentId + ", Patient=" + patient.getName() +
                ", Doctor=" + doctor.getName() + ", Date='" + appointmentDate + "', Status=" + status + "}";
    }
}