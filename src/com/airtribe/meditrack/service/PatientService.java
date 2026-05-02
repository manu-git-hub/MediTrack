package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.Validator;

import java.util.List;

public class PatientService implements Searchable<Patient> {

    private DataStore<Patient> patientStore;

    public PatientService(DataStore<Patient> patientStore) {
        this.patientStore = patientStore;
    }

    public void addPatient(Patient patient) {
        Validator.validateName(patient.getName());
        Validator.validateEmail(patient.getEmail());
        Validator.validateAge(patient.getAge());

        patientStore.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    @Override
    public Patient searchById(String id) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getPatientId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // polymorphism - search by name
    public List<Patient> searchPatient(String name) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }

    // polymorphism - search by age
    public List<Patient> searchPatient(int age) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getAge() == age)
                .toList();
    }

    public void deletePatient(String id) {
        Patient patient = searchById(id);
        if (patient != null) {
            patient.markDeleted();
        }
    }

    //CSV
    public void loadPatients(List<Patient> patients) {
        patients.forEach(patientStore::add);
    }


}
