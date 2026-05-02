package com.airtribe.meditrack.util;

import java.time.LocalDateTime;
import java.util.Scanner;

public class InputUtil {

    public static String readString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            return input;
        }
    }

    public static String readEmail(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: email cannot be empty");
                continue;
            }

            if (!input.contains("@")) {
                System.out.println("Error: invalid email");
                continue;
            }

            return input;
        }
    }

    public static String readPhone(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: phone cannot be empty");
                continue;
            }

            if (!input.matches("\\d{10}")) {
                System.out.println("Error: phone must contain exactly 10 digits");
                continue;
            }

            return input;
        }
    }

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                int value = Integer.parseInt(input);

                if (value <= 0) {
                    System.out.println("Error: value must be greater than 0");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: please enter valid integer");
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                double value = Double.parseDouble(input);

                if (value <= 0) {
                    System.out.println("Error: value must be greater than 0");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: please enter valid decimal number");
            }
        }
    }

    public static LocalDateTime readDateTime(
            Scanner sc,
            String message
    ) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                return LocalDateTime.parse(input);

            } catch (Exception e) {
                System.out.println(
                        "Error: format should be yyyy-MM-ddTHH:mm"
                );
            }
        }
    }

    public static <T extends Enum<T>> T readEnum(
            Scanner sc,
            String message,
            Class<T> enumClass
    ) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Error: value cannot be empty");
                continue;
            }

            try {
                return Enum.valueOf(enumClass, input.trim());

            } catch (Exception e) {
                System.out.println("Error: invalid option");
            }
        }
    }
}