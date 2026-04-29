package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final DataStore<Patient> patients = new DataStore<>();

    public List<Patient> getPatients() {

        return patients.getAll();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient searchPatientById(int patientId) {
        for (Patient patient : patients.getAll()) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }


    public List<Patient> searchPatient(String name)
    {
        List<Patient> result = new ArrayList<>();
        for(Patient patient: patients.getAll())
        {
            if(patient.getName().equalsIgnoreCase(name)) {
                result.add(patient);
            }
        }

        return result;
    }

    public List<Patient> searchPatient(int age)
    {
        List<Patient> result = new ArrayList<>();
        for(Patient patient: patients.getAll())
        {
            if(patient.getAge() == age) {
                result.add(patient);
            }
        }

        return result;
    }

    public Patient updatePatient(int patientId, String name, String address, String email, String phone, int age) {

        Patient patient = searchPatientById(patientId);

        if (patient != null) {
            patient.setName(name);
            patient.setAddress(address);
            patient.setEmail(email);
            patient.setPhone(phone);
            patient.setAge(age);
        }

        return patient;
    }

    public void deletePatient(int patientId) {
        Patient patientToDelete = searchPatientById(patientId);
        if (patientToDelete != null) {
            patients.remove(patientToDelete);
        }
    }
}

