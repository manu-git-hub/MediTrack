package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.exception.InvalidDataException;
import com.airtribe.meditrack.util.DataStore;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {

    private final DataStore<Appointment> appointmentStore;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentService(
            DataStore<Appointment> appointmentStore,
            PatientService patientService,
            DoctorService doctorService
    ) {
        this.appointmentStore = appointmentStore;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    public Appointment bookAppointment(
            String patientId,
            String doctorId,
            LocalDateTime time
    ) {

        Patient patient = patientService.searchById(patientId);

        if (patient == null || patient.isDeleted()) {
            throw new InvalidDataException("Patient not found");
        }

        Doctor doctor = doctorService.searchById(doctorId);

        if (doctor == null || doctor.isDeleted()) {
            throw new InvalidDataException("Doctor not found");
        }

        boolean doctorBusy = appointmentStore.getAll()
                .stream()
                .anyMatch(a ->
                        a.getDoctorId().equals(doctorId)
                                && a.getAppointmentTime().equals(time)
                                && a.getStatus() == AppointmentStatus.CONFIRMED
                );

        if (doctorBusy) {
            throw new InvalidDataException(
                    "Doctor not available at selected time"
            );
        }

        Appointment appointment =
                new Appointment(patientId, doctorId, time);

        appointmentStore.add(appointment);
        return appointment;
    }

    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentStore.getAll()
                .stream()
                .filter(a -> a.getAppointmentId().equals(appointmentId))
                .findFirst()
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment not found"
                        ));

        appointment.cancel();
    }

    public List<Appointment> getAllAppointments() {
        return appointmentStore.getAll();
    }

    public List<Appointment> getConfirmedAppointments() {
        return appointmentStore.getAll()
                .stream()
                .filter(a -> a.getStatus() == AppointmentStatus.CONFIRMED)
                .toList();
    }
}