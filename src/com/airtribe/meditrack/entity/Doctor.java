package com.airtribe.meditrack.entity;

public class Doctor extends Person {
    private String specialization;

    public Doctor(int doctorId, String name, String password, String address, String phone, String email, int age,
            String specialization) {
        super(doctorId, name, password, address, phone, email, "Doctor", age);
        this.specialization = specialization;

    }

    public int getDoctorId() {
        return getMedicalEntityId();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "{" +
                "doctorId=" + getDoctorId() +
                ", name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", personType='" + getPersonType() + '\'' +
                ", age='" + getAge() + '\'' +
                ", specialization='" + getSpecialization() + '\'' +
                '}';
    }
}
