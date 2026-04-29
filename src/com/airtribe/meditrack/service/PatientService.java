package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.repository.PatientRepository;

import java.util.List;

public class PatientService {

    private final PatientRepository _patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        _patientRepository = patientRepository;
    }

    public void registerPatient(Patient patient)
    {
        _patientRepository.addPatient(patient);
        System.out.println("Patient Added Successfully");
    }

    public List<Patient> viewAllPatients()
    {
        return _patientRepository.getPatients();
    }

    public List<Patient> searchPatientByName(String name)
    {
        return _patientRepository.searchPatient(name);
    }
    
}
