package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    private final DataStore<Doctor> doctors = new DataStore<>();

    public List<Doctor> getDoctorList()
    {
        return doctors.getAll();
    }

    public void addDoctor(Doctor doctor)
    {
        doctors.add(doctor);
    }

    public Doctor getDoctorById(int doctorId)
    {
        for(Doctor doctor : doctors.getAll())
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

        if(doctor != null) {
            doctor.setName(name);
            doctor.setEmail(email);
            doctor.setPhone(phone);
            doctor.setAddress(address);
        }

        return doctor;
    }

    public void deleteDoctor(int doctorId)
    {
        Doctor doctorToDelete = getDoctorById(doctorId);
        if (doctorToDelete != null) {
            doctors.remove(doctorToDelete);
        }
    }

}
