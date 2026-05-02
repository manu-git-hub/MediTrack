package com.airtribe.meditrack.csv;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.service.AppointmentService;
import com.airtribe.meditrack.service.BillingService;
import com.airtribe.meditrack.service.DoctorService;
import com.airtribe.meditrack.service.PatientService;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVDataLoader {

    public static void loadAll(PatientService patientService, DoctorService doctorService, AppointmentService appointmentService, BillingService billingService) {

        List<String[]> patientRows = CSVUtil.read(Constants.PATIENT_FILE);
        List<Patient> patients = new ArrayList<>();

        for (String[] r : patientRows) {
            if (r.length < 7 || r[0].equalsIgnoreCase("patientId"))
                continue;

            Patient p = new Patient(r[0], r[1], r[2], r[3], r[4], Integer.parseInt(r[5]));

            if (Boolean.parseBoolean(r[6]))
                p.markDeleted();

            patients.add(p);
        }

        int paitentCounterLastValue = Integer.valueOf(patients.get(patients.size() - 1).getPatientId().replace(IdGenerator.PREFIX_PAITENT, ""));
        IdGenerator.initializeCounters(IdGenerator.PREFIX_PAITENT, paitentCounterLastValue);

        // patientService.loadPatients(patients);

        List<String[]> doctorRows = CSVUtil.read(Constants.DOCTOR_FILE);
        List<Doctor> doctors = new ArrayList<>();

        for (String[] r : doctorRows) {
            if (r.length < 9 || r[0].equalsIgnoreCase("doctorId"))
                continue;

            Doctor d = new Doctor(r[0], r[1], r[2], r[3], r[4], Integer.parseInt(r[5]), Specialization.valueOf(r[6]), Double.parseDouble(r[7]));

            if (Boolean.parseBoolean(r[8]))
                d.markDeleted();

            doctors.add(d);
        }
        // doctorService.loadDoctors(doctors);

        List<String[]> apptRows = CSVUtil.read(Constants.APPOINTMENT_FILE);
        List<Appointment> appointments = new ArrayList<>();

        for (String[] r : apptRows) {
            if (r.length < 5 || r[0].equalsIgnoreCase("appointmentId"))
                continue;

            Appointment a = new Appointment(r[0], r[1], r[2], LocalDateTime.parse(r[3]), AppointmentStatus.valueOf(r[4]));

            appointments.add(a);
        }
        // appointmentService.loadAppointments(appointments);

        List<String[]> billRows = CSVUtil.read(Constants.BILL_FILE);
        List<Bill> bills = new ArrayList<>();

        for (String[] r : billRows) {
            if (r.length < 5 || r[0].equalsIgnoreCase("billId"))
                continue;

            Bill b = new Bill(r[1], // appointmentId
                    Double.parseDouble(r[2]) // fee
            );

            bills.add(b);
        }
        // billingService.loadBills(bills);

    }

    public static int setAtomicCounterId(List<Patient> patients) {
        int maxId = 0;

        for (Patient p : patients) {
            String id = p.getPatientId();

            if (id == null || !id.startsWith(IdGenerator.PREFIX_PAITENT))
                continue;

            int num = Integer.parseInt(id.substring(IdGenerator.PREFIX_PAITENT.length()));
            maxId = Math.max(maxId, num);
        }

        IdGenerator.initializeCounters(IdGenerator.PREFIX_PAITENT, maxId);
        return 0;
    }

    //SAVE CSV
    public static void saveAll(PatientService ps, DoctorService ds, AppointmentService as, BillingService bs) {
        // Save Patients
        List<String> patientLines = new ArrayList<>();
        patientLines.add("patientId,name,address,phone,email,age,deleted");
        for (Patient p : ps.getAllPatients()) {
            patientLines.add(String.join(",", p.getPatientId(), p.getName(), p.getAddress(), p.getPhone(), p.getEmail(), String.valueOf(p.getAge()), String.valueOf(p.isDeleted())));
        }
        CSVUtil.write(Constants.PATIENT_FILE, patientLines);

        // Save Doctors
        List<String> doctorLines = new ArrayList<>();
        doctorLines.add("doctorId,name,address,phone,email,age,specialization,fee,deleted");
        for (Doctor d : ds.getAllDoctors()) {
            doctorLines.add(String.join(",", d.getDoctorId(), d.getName(), d.getAddress(), d.getPhone(), d.getEmail(), String.valueOf(d.getAge()), d.getSpecialization().name(), String.valueOf(d.getConsultationFee()), String.valueOf(d.isDeleted())));
        }
        CSVUtil.write(Constants.DOCTOR_FILE, doctorLines);

        // Save Appointments
        List<String> apptLines = new ArrayList<>();
        apptLines.add("appointmentId,patientId,doctorId,time,status");
        for (Appointment a : as.getAllAppointments()) {
            apptLines.add(String.join(",", a.getAppointmentId(), a.getPatientId(), a.getDoctorId(), a.getAppointmentTime().toString(), a.getStatus().name()));
        }
        CSVUtil.write(Constants.APPOINTMENT_FILE, apptLines);

        // Save Bills
        List<String> billLines = new ArrayList<>();
        billLines.add("billId,appointmentId,fee,tax,total");
        for (Bill b : bs.getAllBills()) {
            billLines.add(String.join(",", b.getBillId(), b.getAppointmentId(), String.valueOf(b.getSummary().getConsultationFee()), String.valueOf(b.getSummary().getTaxAmount()), String.valueOf(b.getSummary().getTotalAmount())));
        }
        CSVUtil.write(Constants.BILL_FILE, billLines);
    }
}