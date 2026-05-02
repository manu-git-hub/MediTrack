package com.airtribe.meditrack;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.airtribe.meditrack.csv.CSVDataLoader;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.service.AppointmentService;
import com.airtribe.meditrack.service.BillingService;
import com.airtribe.meditrack.service.DoctorService;
import com.airtribe.meditrack.service.PatientService;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.util.InputUtil;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DataStore<Patient> patientStore = new DataStore<>();
		DataStore<Doctor> doctorStore = new DataStore<>();
		DataStore<Appointment> appointmentStore = new DataStore<>();
		DataStore<Bill> billStore = new DataStore<>();

		PatientService patientService = new PatientService(patientStore);
		DoctorService doctorService = new DoctorService(doctorStore);
		AppointmentService appointmentService =
				new AppointmentService(
						appointmentStore,
						patientService,
						doctorService
				);
		BillingService billingService = new BillingService(billStore);

		if (args.length > 0 && args[0].equals("--loadData")) {
			CSVDataLoader.loadAll(
					patientService,
					doctorService,
					appointmentService,
					billingService
			);
			System.out.println("CSV data loaded successfully.");
		}

		while (true) {
			try {
				printMenu();

				int choice = InputUtil.readInt(
						sc,
						"Choose option: "
				);

				switch (choice) {

					case 1:
						addPatient(sc, patientService);
						break;

					case 2:
						addDoctor(sc, doctorService);
						break;

					case 3:
						bookAppointment(
								sc,
								appointmentService
						);
						break;

					case 4:
						cancelAppointment(
								sc,
								appointmentService
						);
						break;

					case 5:
						generateBill(
								sc,
								billingService
						);
						break;

					case 6:
						viewPatients(patientService);
						break;

					case 7:
						viewDoctors(doctorService);
						break;

					case 8:
						viewAppointments(appointmentService);
						break;

					case 9:
						System.out.println(
								"\nThank you for using MediTrack"
						);
						System.exit(0);

					default:
						System.out.println(
								"Invalid option"
						);
				}

			} catch (Exception e) {
				System.out.println(
						"\nError: " + e.getMessage()
				);
			}
		}
	}

	private static void printMenu() {
		System.out.println("\n==============================");
		System.out.println("        MEDITRACK SYSTEM      ");
		System.out.println("==============================");
		System.out.println("1. Add Patient");
		System.out.println("2. Add Doctor");
		System.out.println("3. Book Appointment");
		System.out.println("4. Cancel Appointment");
		System.out.println("5. Generate Bill");
		System.out.println("6. View Patients");
		System.out.println("7. View Doctors");
		System.out.println("8. View Appointments");
		System.out.println("9. Exit");
		System.out.println("==============================");
	}

	private static void addPatient(
			Scanner sc,
			PatientService patientService
	) {
		System.out.println("\n--- Add Patient ---");

		Patient patient = new Patient(
				InputUtil.readString(sc, "Name: "),
				InputUtil.readString(sc, "Address: "),
				InputUtil.readPhone(sc, "Phone: "),
				InputUtil.readEmail(sc, "Email: "),
				InputUtil.readInt(sc, "Age: ")
		);

		patientService.addPatient(patient);

		System.out.println("\nPatient Added Successfully");
		System.out.println("--------------------------");
		System.out.println("Patient ID : " + patient.getPatientId());
		System.out.println("Name       : " + patient.getName());
		System.out.println("Age        : " + patient.getAge());
	}

	private static void addDoctor(
			Scanner sc,
			DoctorService doctorService
	) {
		System.out.println("\n--- Add Doctor ---");

		String name = InputUtil.readString(sc, "Name: ");
		String address = InputUtil.readString(sc, "Address: ");
		String phone = InputUtil.readPhone(sc, "Phone: ");
		String email = InputUtil.readEmail(sc, "Email: ");
		int age = InputUtil.readInt(sc, "Age: ");

		System.out.println("\nAvailable Specializations:");
		for (Specialization specialization :
				Specialization.values()) {
			System.out.println("- " + specialization);
		}

		Specialization specialization =
				InputUtil.readEnum(
						sc,
						"Specialization: ",
						Specialization.class
				);

		double fee =
				InputUtil.readDouble(
						sc,
						"Consultation Fee: "
				);

		Doctor doctor = new Doctor(
				name,
				address,
				phone,
				email,
				age,
				specialization,
				fee
		);

		doctorService.addDoctor(doctor);

		System.out.println("\nDoctor Added Successfully");
		System.out.println("--------------------------");
		System.out.println("Doctor ID   : " + doctor.getDoctorId());
		System.out.println("Name        : " + doctor.getName());
		System.out.println("Speciality  : " + doctor.getSpecialization());
		System.out.println("Fee         : " + doctor.getConsultationFee());
	}

	private static void bookAppointment(
			Scanner sc,
			AppointmentService appointmentService
	) {
		System.out.println("\n--- Book Appointment ---");

		Appointment appointment =
				appointmentService.bookAppointment(
						InputUtil.readString(sc, "Patient ID: "),
						InputUtil.readString(sc, "Doctor ID: "),
						InputUtil.readDateTime(
								sc,
								"Appointment Time (yyyy-MM-ddTHH:mm): "
						)
				);

		System.out.println("\nAppointment Booked Successfully");
		System.out.println("-------------------------------");
		System.out.println(
				"Appointment ID : " +
						appointment.getAppointmentId()
		);
		System.out.println(
				"Status         : " +
						appointment.getStatus()
		);
	}

	private static void cancelAppointment(
			Scanner sc,
			AppointmentService appointmentService
	) {
		System.out.println("\n--- Cancel Appointment ---");

		String appointmentId =
				InputUtil.readString(
						sc,
						"Appointment ID: "
				);

		appointmentService.cancelAppointment(
				appointmentId
		);

		System.out.println(
				"\nAppointment Cancelled Successfully"
		);
	}

	private static void generateBill(
			Scanner sc,
			BillingService billingService
	) {
		System.out.println("\n--- Generate Bill ---");

		Bill bill =
				billingService.generateBill(
						InputUtil.readString(
								sc,
								"Appointment ID: "
						),
						InputUtil.readDouble(
								sc,
								"Consultation Fee: "
						)
				);

		System.out.println("\nBill Generated Successfully");
		System.out.println("---------------------------");
		System.out.println(
				"Bill ID         : " +
						bill.getBillId()
		);
		System.out.println(
				"Appointment ID  : " +
						bill.getAppointmentId()
		);
	}

	private static void viewPatients(
			PatientService patientService
	) {
		System.out.println("\n--- Patient List ---");

		for (Patient patient :
				patientService.getAllPatients()) {
			System.out.println(
					patient.getPatientId() +
							" | " +
							patient.getName() +
							" | Age: " +
							patient.getAge()
			);
		}
	}

	private static void viewDoctors(
			DoctorService doctorService
	) {
		System.out.println("\n--- Doctor List ---");

		for (Doctor doctor :
				doctorService.getAllDoctors()) {
			System.out.println(
					doctor.getDoctorId() +
							" | " +
							doctor.getName() +
							" | " +
							doctor.getSpecialization() +
							" | Fee: " +
							doctor.getConsultationFee()
			);
		}
	}

	private static void viewAppointments(
			AppointmentService appointmentService
	) {
		System.out.println("\n--- Appointment List ---");

		for (Appointment appointment :
				appointmentService.getAllAppointments()) {
			System.out.println(
					appointment.getAppointmentId() +
							" | Patient: " +
							appointment.getPatientId() +
							" | Doctor: " +
							appointment.getDoctorId() +
							" | Status: " +
							appointment.getStatus()
			);
		}
	}
}