import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.exception.UserNotFoundExpection;
import com.airtribe.meditrack.repository.PatientRepository;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Test Data
        PatientRepository patientRepository = new PatientRepository();

        patientRepository.addPatient(
                new Patient(
                        1,
                        "Sujith",
                        "Sujith@123",
                        "Chennai",
                        "8825842189",
                        "sujith@gmail.com",
                        25));

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║          WELCOME             ║");
        System.out.println("║             TO               ║");
        System.out.println("║         MEDITRACK            ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.println();

        // PHONE NUMBER VALIDATION

        String phoneNumber;

        while (true) {

            System.out.print("Please Enter Your Phone Number: ");
            phoneNumber = scanner.nextLine();

            if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid Phone Number.");
                System.out.println("Phone number must contain exactly 10 digits.");
            }
        }

        Patient existingPatient = null;

        for (Patient patient : patientRepository.searchPatientByPhone(phoneNumber)) {
            if (patient.getPhone().equals(phoneNumber)) {
                existingPatient = patient;
                break;
            }
        }

        // USER NOT FOUND
        if (existingPatient == null) {
            // System.out.println();
            // System.out.println("User does not exist in repository.");
            // System.out.println("Do you want to create a new account?");

        } else {

            // USER FOUND

            System.out.println();
            System.out.println("User Found Successfully");
            System.out.println();

            System.out.println("+--------------------------------+");
            System.out.println("|        PATIENT DETAILS         |");
            System.out.println("+--------------------------------+");

            System.out.println("| Name         : " + existingPatient.getName());
            System.out.println("| Age          : " + existingPatient.getAge());
            System.out.println("| Phone Number : " + existingPatient.getPhone());
            System.out.println("| Email ID     : " + existingPatient.getEmail());
            System.out.println("| Address      : " + existingPatient.getAddress());

            System.out.println("+--------------------------------+");

            System.out.println();

            System.out.print("Are you sure this is your account? (Y/N): ");

            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {

                // PASSWORD VALIDATION

                String password;

                while (true) {

                    System.out.print("🔐 Enter Password: ");
                    password = scanner.nextLine();

                    boolean isValidPassword = Pattern.matches(
                            "^(?=.*[A-Z])(?=.*[@#]).{8,}$",
                            password);

                    if (isValidPassword) {

                        System.out.println();
                        System.out.println("Authentication Successful");
                        System.out.println("Welcome to MediTrack");

                        break;

                    } else {

                        System.out.println();
                        System.out.println("Invalid Password");
                        System.out.println("Password must contain:");
                        System.out.println("✔ Minimum 8 characters");
                        System.out.println("✔ At least 1 uppercase letter");
                        System.out.println("✔ At least 1 special character (@ or #)");
                    }
                }

            } else {

                System.out.println();
                System.out.println("Authentication Cancelled");
            }
        }

        scanner.close();
    }
}