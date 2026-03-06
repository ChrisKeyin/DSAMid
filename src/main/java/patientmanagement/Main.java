package patientmanagement;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientQueue patientQueue = new PatientQueue();
    private static final PatientHistory patientHistory = new PatientHistory();

    public static void main(String[] args) {
        patientHistory.loadSampleHistory();

        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    waitingRoomMenu();
                    break;
                case 2:
                    patientHistoryMenu();
                    break;
                case 3:
                    System.out.println("Exiting. Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n======================================");
        System.out.println(" Patient Management System");
        System.out.println("======================================");
        System.out.println("1. Patient Waiting Room");
        System.out.println("2. Patient History System");
        System.out.println("3. Exit");
        System.out.println("======================================");
    }

    private static void waitingRoomMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n----------- Patient Waiting Room -----------");
            System.out.println("1. Add patient to queue");
            System.out.println("2. Serve next patient");
            System.out.println("3. Insert emergency patient at position");
            System.out.println("4. Print all patients in queue");
            System.out.println("5. Back to main menu");
            System.out.println("--------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addPatientToQueue();
                    break;
                case 2:
                    serveNextPatient();
                    break;
                case 3:
                    insertEmergencyPatient();
                    break;
                case 4:
                    patientQueue.printPatients();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPatientToQueue() {
        int id = readInt("Enter patient ID: ");
        String name = readNonEmptyString("Enter patient name: ");
        String reason = readNonEmptyString("Enter reason for visit: ");

        Patient patient = new Patient(id, name, reason);
        patientQueue.addPatient(patient);

        System.out.println("Patient added to queue successfully.");
    }

    private static void serveNextPatient() {
        Patient servedPatient = patientQueue.serveNextPatient();

        if (servedPatient == null) {
            System.out.println("No patients to serve. The queue is empty.");
        } else {
            System.out.println("Serving patient:");
            System.out.println(servedPatient);
        }
    }

    private static void insertEmergencyPatient() {
        int id = readInt("Enter patient ID: ");
        String name = readNonEmptyString("Enter patient name: ");
        String reason = readNonEmptyString("Enter reason for visit: ");
        int position = readInt("Enter queue position to insert patient at: ");

        Patient patient = new Patient(id, name, reason);
        patientQueue.insertPatientAtPosition(patient, position);

        System.out.println("Emergency patient inserted successfully.");
    }

    private static void patientHistoryMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n----------- Patient History System -----------");
            System.out.println("1. View current record");
            System.out.println("2. Move to next record");
            System.out.println("3. Move to previous record");
            System.out.println("4. View newest record");
            System.out.println("5. View oldest record");
            System.out.println("6. Back to main menu");
            System.out.println("----------------------------------------------");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    displayCurrentRecord();
                    break;
                case 2:
                    moveToNextRecord();
                    break;
                case 3:
                    moveToPreviousRecord();
                    break;
                case 4:
                    displayNewestRecord();
                    break;
                case 5:
                    displayOldestRecord();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCurrentRecord() {
        PatientRecord record = patientHistory.getCurrentRecord();

        if (record == null) {
            System.out.println("No current record available.");
        } else {
            System.out.println("\nCurrent Record:");
            System.out.println(record);
        }
    }

    private static void moveToNextRecord() {
        boolean moved = patientHistory.moveToNextRecord();

        if (!moved) {
            System.out.println("You are already at the newest record. Cannot move forward.");
        } else {
            System.out.println("Moved to next record:");
            System.out.println(patientHistory.getCurrentRecord());
        }
    }

    private static void moveToPreviousRecord() {
        boolean moved = patientHistory.moveToPreviousRecord();

        if (!moved) {
            System.out.println("You are already at the oldest record. Cannot move backward.");
        } else {
            System.out.println("Moved to previous record:");
            System.out.println(patientHistory.getCurrentRecord());
        }
    }

    private static void displayNewestRecord() {
        PatientRecord record = patientHistory.getNewestRecord();

        if (record == null) {
            System.out.println("No records available.");
        } else {
            patientHistory.moveToNewestRecord();
            System.out.println("\nNewest Record:");
            System.out.println(record);
        }
    }

    private static void displayOldestRecord() {
        PatientRecord record = patientHistory.getOldestRecord();

        if (record == null) {
            System.out.println("No records available.");
        } else {
            patientHistory.moveToOldestRecord();
            System.out.println("\nOldest Record:");
            System.out.println(record);
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}