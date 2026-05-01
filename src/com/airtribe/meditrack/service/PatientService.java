package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.repository.PatientRepository;

import java.util.List;

public class PatientService {

    private final PatientRepository _patientRepository;

    public PatientService(PatientRepository patientRepository) {
        _patientRepository = patientRepository;
    }

    public void registerPatient(Patient patient) {
        _patientRepository.addPatient(patient);
        System.out.println("Patient Added Successfully");
    }

    public List<Patient> viewAllPatients() {
        return _patientRepository.getPatients();
    }

    public List<Patient> searchPatientByPhone(String phone) {
        return _patientRepository.searchPatientByPhone(phone);

    }

    public Patient updatePatient(int patientId, String name, String password, String address, String email,
            String phone, int age) {
        return _patientRepository.updatePatient(patientId, name, password, address, email, phone, age);
    }

    public void removePatient(int patientId) {
        _patientRepository.deletePatient(patientId);
    }

}
