package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    public List<Doctor> doctorList = new ArrayList<>();

    public List<Doctor> getDoctorList()
    {
        return doctorList;
    }

    public void addDoctor(Doctor doctor)
    {
        doctorList.add(doctor);
    }

    public Doctor getDoctorById(int doctorId)
    {
        for(Doctor doctor : doctorList)
        {
            if(doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }

        return null;
    }

    public Doctor updateDoctor(int doctorId, String name, String address, String email, String phone)
    {
        Doctor doctor = getDoctorById(doctorId);

        doctor.setName(name);
        doctor.setEmail(email);
        doctor.setPhone(phone);
        doctor.setAddress(address);

        return doctor;
    }

    public void deleteDoctor(int doctorId)
    {
        doctorList.removeIf(doctorList -> doctorList.getDoctorId() == doctorId);
    }

}
