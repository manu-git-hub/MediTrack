package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();

    public List<Patient> getPatient() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient getPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public Patient updatePatient(int patientId, String name, String address, String email, String phone) {

        Patient patient = getPatientById(patientId);

//        patient.setName(name);
//        patient.setAddress(address);
//        patient.setEmail(email);
//        patient.setPhone(phone);

        return patient;
    }

    public void deletePatient(int patientsId) {
        patients.removeIf(patients -> patients.getPatientId() == patientsId);
    }
}

