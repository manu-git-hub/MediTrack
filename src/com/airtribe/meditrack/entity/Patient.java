package com.airtribe.meditrack.entity;

public class Patient extends Person {
    private int patientId;

    public Patient(int patientId, String name, String address, String phone, String email, int age) {
        super(name, address, phone, email, "Patient", age);
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

    @Override
    public String toString() {
        return "{" +
                "patientId=" + patientId +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                ", age='" + getPersonAge() + '\'' +
                '}';
    }

}
