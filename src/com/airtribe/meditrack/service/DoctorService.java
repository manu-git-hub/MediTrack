package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.repository.DoctorRepository;

import java.util.List;

public class DoctorService {
    private final DoctorRepository _doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        _doctorRepository = doctorRepository;
    }

    //View all doctors
    public List<Doctor> viewDoctorList() {
        return _doctorRepository.getDoctorList();
    }

    //Add new Doctor
    public void addDoctor(Doctor doctor) {
        _doctorRepository.addDoctor(doctor);
    }

    //Update Doctor
    public Doctor updateDoctor(int doctorId, String name, String address, String email, String phone, int age) {
        return _doctorRepository.updateDoctor(doctorId, name, address, email, phone, age);
    }

    //Delete Doctor
    public void removeDoctor(int doctorId) {
        _doctorRepository.deleteDoctor(doctorId);
    }
}
