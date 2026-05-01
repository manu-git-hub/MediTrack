package com.airtribe.meditrack.entity;

public class Doctor extends Person {
    private int doctorId;

    public Doctor(int doctorId, String name, String password, String address, String phone, String email, int age) {
        super(name, password, address, phone, email, "Doctor", age);
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
                ", password='" + getPassword() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }
}
