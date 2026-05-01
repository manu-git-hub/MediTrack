package com.airtribe.meditrack.repository;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class AppointmentRepository {

    private final DataStore<Appointment> appointments = new DataStore<>();

    public void save(Appointment appt) {
        appointments.add(appt);
    }

    public List<Appointment> findAll() {
        return appointments.getAll();
    }

    public Appointment findById(int id) {
        for (Appointment a : appointments.getAll()) {
            if (a.getAppointmentId() == id)
                return a;
        }
        return null;
    }

    public List<Appointment> getAppointmentList() {
        return appointments.getAll();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment getAppointmentById(int appointmentId) {

        for (Appointment appointment : appointments.getAll()) {

            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }

        return null;
    }

    public Appointment updateAppointment(
            int appointmentId,
            String appointmentDate,
            String appointmentTime,
            String reason,
            String status) {

        Appointment appointment = getAppointmentById(appointmentId);

        if (appointment != null) {

            // appointment.setAppointmentDate(appointmentDate);
            // appointment.setAppointmentTime(appointmentTime);
            // appointment.setReason(reason);
            // appointment.setStatus(status);
        }

        return appointment;
    }

    public void deleteAppointment(int appointmentId) {

        Appointment appointmentToDelete = getAppointmentById(appointmentId);

        if (appointmentToDelete != null) {
            appointments.remove(appointmentToDelete);
        }
    }
}