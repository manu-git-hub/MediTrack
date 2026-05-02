package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorService implements Searchable<Doctor> {

    private DataStore<Doctor> doctorStore;

    public DoctorService(DataStore<Doctor> doctorStore) {
        this.doctorStore = doctorStore;
    }
    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    @Override
    public Doctor searchById(String id) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getDoctorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Doctor> filterBySpecialization(Specialization specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization() == specialization)
                .toList();
    }

    public double averageFee() {
        return doctorStore.getAll()
                .stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0);
    }

}
