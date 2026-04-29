package com.airtribe.meditrack.entity;

public class Doctor extends Person {
    int doctorId;

    public Doctor(int doctorId, String name, String address, String phone, String email) {
        super(name, address, phone, email, "Doctor");
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "{" +
                "doctorId=" + doctorId +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                '}';
    }
}
