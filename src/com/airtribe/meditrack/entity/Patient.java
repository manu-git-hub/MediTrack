package com.airtribe.meditrack.entity;

public class Patient extends Person {
    int patientId;

    public Patient(int patientId, String name, String address, String phone, String email) {
        super(name, address, phone, email, "Patient");
        this.patientId = patientId;
    }


}
