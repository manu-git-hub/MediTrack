package com.airtribe.meditrack.service;

import com.airtribe.meditrack.Enum.AppointmentStatus;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.repository.AppointmentRepository;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepository repo;
    public AppointmentService(AppointmentRepository repo) { this.repo = repo; }

    public void scheduleAppointment(Appointment appt) {
        repo.save(appt);
        System.out.println("Appointment Scheduled!");
    }

    public List<Appointment> viewAllAppointments() {
        return repo.findAll();
    }

    public void cancelAppointment(int id) throws AppointmentNotFoundException {
        Appointment appt = repo.findById(id);
        if (appt == null) throw new AppointmentNotFoundException("Cannot cancel: Appointment ID " + id + " not found.");
        appt.setStatus(AppointmentStatus.CANCELLED);
        System.out.println("Appointment Cancelled.");
    }
}
