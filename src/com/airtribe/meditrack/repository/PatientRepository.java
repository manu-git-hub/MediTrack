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

    public Patient searchPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> searchPatient(String name)
    {
        List<Patient> result = new ArrayList<>();
        for(Patient patient: patients)
        {
            if(patient.getName() == name) {
                result.add(patient);
            }
        }

        return result;
    }

    public List<Patient> searchPatient(int age)
    {
        List<Patient> result = new ArrayList<>();
        for(Patient patient: patients)
        {
            if(patient.getPersonAge() == age) {
                result.add(patient);
            }
        }

        return result;
    }

    public Patient updatePatient(int patientId, String name, String address, String email, String phone, int age) {

        Patient patient = searchPatientById(patientId);

        patient.setName(name);
        patient.setAddress(address);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setAge(age);

        return patient;
    }

    public void deletePatient(int patientsId) {
        patients.removeIf(patients -> patients.getPatientId() == patientsId);
    }
}

