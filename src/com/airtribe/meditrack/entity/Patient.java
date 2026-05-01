package com.airtribe.meditrack.entity;

public class Patient extends Person {

    public Patient(int patientId, String name, String password, String address, String phone, String email, int age) {
        super(patientId, name, password, address, phone, email, "Patient", age);

    }

    public int getPatientId() {
        return getMedicalEntityId();
    }

    @Override
    public String toString() {
        return "{" +
                "patientId=" + getPatientId() +
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
