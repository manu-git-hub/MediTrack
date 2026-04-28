package com.airtribe.meditrack.entity;

public class Doctor extends Person {
    int doctorId;

    public Doctor(int doctorId, String name, String address, String phone, String email) {
        super(name, address, phone, email, "Doctor");
        this.doctorId = doctorId;
    }

    
}
