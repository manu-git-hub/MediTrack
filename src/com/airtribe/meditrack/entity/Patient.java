package com.airtribe.meditrack.entity;

public class Patient extends Person {

    public Patient(int patientId, String name, String address, String phone, String email, int age) {
        super(patientId,name, address, phone, email, "Patient", age);

    }

    public int getPatientId() {
        return getMedicalEntityId();
    }

    @Override
    public String toString() {
        return "{" +
                "patientId=" + getPatientId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }

}
