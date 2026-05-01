package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class AppointmentRepository {

    private final DataStore<Appointment> appointments = new DataStore<>();
    public void save(Appointment appt) { appointments.add(appt); }
    public List<Appointment> findAll() { return appointments.getAll(); }

    public Appointment findById(int id) {
        for (Appointment a : appointments.getAll()) {
            if (a.getAppointmentId() == id) return a;
        }
        return null;
    }
}
