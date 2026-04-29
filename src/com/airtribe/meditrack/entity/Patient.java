package com.airtribe.meditrack.entity;

public class Patient extends Person {
    int patientId;

    public Patient(int patientId, String name, String address, String phone, String email) {
        super(name, address, phone, email, "Patient");
        this.patientId = patientId;
    }

    //Getter
    public int getPatientId() {
        return patientId;
    }


    //Setter
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

}
