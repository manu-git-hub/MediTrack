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

    public List<Patient> searchPatient(String name, Integer age)
    {
        if(age != null) {
            return _patientRepository.searchPatient(age);
        }

        else{
            return _patientRepository.searchPatient(name);
        }
    }


    public Patient updatePatient(int patientId, String name, String address, String email, String phone, int age)
    {
        return _patientRepository.updatePatient(patientId, name, address, email, phone, age);
    }

    public void removePatient(int patientId)
    {
         _patientRepository.deletePatient(patientId);
    }
    
}
