package com.hospital;

import com.hospital.datastructures.BST;
import com.hospital.datastructures.Queue;
import com.hospital.datastructures.SinglyLinkedList;
import com.hospital.datastructures.Stack;
import com.hospital.models.Patient;
import com.hospital.models.Visit;
import java.util.Scanner;

public class Main {
    private static BST patientBST = new BST();
    private static Queue emergencyQueue = new Queue();
    private static Stack treatmentStack = new Stack();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("===================================");
        
        // Add some sample data
        initializeSampleData();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    managePatientRecords();
                    break;
                case 2:
                    manageEmergencyQueue();
                    break;
                case 3:
                    manageTreatmentHistory();
                    break;
                case 4:
                    manageVisitHistory();
                    break;
                case 5:
                    displayAllData();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Manage Patient Records (BST)");
        System.out.println("2. Manage Emergency Queue");
        System.out.println("3. Manage Treatment History (Stack)");
        System.out.println("4. Manage Patient Visit History");
        System.out.println("5. Display All Data");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }
    
    private static void managePatientRecords() {
        System.out.println("\n--- Patient Records (BST) ---");
        System.out.println("1. Insert Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All (In-order)");
        System.out.println("0. Back to Main Menu");
        
        int choice = getIntInput("Choose option: ");
        
        switch (choice) {
            case 1:
                insertPatient();
                break;
            case 2:
                searchPatient();
                break;
            case 3:
                deletePatient();
                break;
            case 4:
                System.out.println("\n--- All Patients (Sorted by ID) ---");
                patientBST.inOrderTraversal();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void insertPatient() {
        int id = getIntInput("Enter Patient ID: ");
        if (patientBST.search(id) != null) {
            System.out.println("Patient with ID " + id + " already exists!");
            return;
        }
        
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter Age: ");
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();
        
        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient inserted successfully!");
    }
    
    private static void searchPatient() {
        int id = getIntInput("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);
        if (patient != null) {
            System.out.println("Patient found: " + patient);
        } else {
            System.out.println("Patient not found.");
        }
    }
    
    private static void deletePatient() {
        int id = getIntInput("Enter Patient ID to delete: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        patientBST.delete(id);
        System.out.println("Patient deleted successfully!");
    }
    
    private static void manageEmergencyQueue() {
        System.out.println("\n--- Emergency Queue ---");
        System.out.println("1. Enqueue Patient");
        System.out.println("2. Dequeue Patient (Treat)");
        System.out.println("3. Display Queue");
        System.out.println("0. Back");
        
        int choice = getIntInput("Choose option: ");
        
        switch (choice) {
            case 1:
                int id = getIntInput("Enter Patient ID to add to queue: ");
                Patient patient = patientBST.search(id);
                if (patient == null) {
                    System.out.println("Patient not found. Please insert patient first.");
                    return;
                }
                emergencyQueue.enqueue(patient);
                break;
            case 2:
                Patient treated = emergencyQueue.dequeue();
                if (treated != null) {
                    treatmentStack.push(treated);
                }
                break;
            case 3:
                emergencyQueue.displayQueue();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void manageTreatmentHistory() {
        System.out.println("\n--- Treatment History (Stack) ---");
        System.out.println("1. Display Treatment Records");
        System.out.println("2. Remove Most Recent Record");
        System.out.println("0. Back");
        
        int choice = getIntInput("Choose option: ");
        
        switch (choice) {
            case 1:
                treatmentStack.displayStack();
                break;
            case 2:
                treatmentStack.pop();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void manageVisitHistory() {
        System.out.println("\n--- Patient Visit History ---");
        int id = getIntInput("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        
        SinglyLinkedList visitHistory = patient.getVisitHistory();
        
        System.out.println("1. Add Visit");
        System.out.println("2. Remove Visit");
        System.out.println("3. Search Visit");
        System.out.println("4. Display All Visits");
        System.out.println("0. Back");
        
        int choice = getIntInput("Choose option: ");
        
        switch (choice) {
            case 1:
                int visitId = getIntInput("Enter Visit ID: ");
                System.out.print("Enter Visit Date: ");
                String date = scanner.nextLine();
                System.out.print("Enter Doctor Name: ");
                String doctor = scanner.nextLine();
                System.out.print("Enter Diagnosis: ");
                String diagnosis = scanner.nextLine();
                System.out.print("Enter Treatment: ");
                String treatment = scanner.nextLine();
                
                Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
                visitHistory.addVisit(visit);
                break;
            case 2:
                int removeId = getIntInput("Enter Visit ID to remove: ");
                if (visitHistory.removeVisit(removeId)) {
                    System.out.println("Visit removed.");
                } else {
                    System.out.println("Visit not found.");
                }
                break;
            case 3:
                int searchId = getIntInput("Enter Visit ID to search: ");
                Visit found = visitHistory.searchVisit(searchId);
                if (found != null) {
                    System.out.println("Visit found: " + found);
                } else {
                    System.out.println("Visit not found.");
                }
                break;
            case 4:
                visitHistory.displayVisits();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void displayAllData() {
        System.out.println("\n========== ALL DATA ==========");
        
        System.out.println("\n--- Patient Records ---");
        patientBST.inOrderTraversal();
        
        System.out.println("\n--- Emergency Queue ---");
        emergencyQueue.displayQueue();
        
        System.out.println("\n--- Treatment History ---");
        treatmentStack.displayStack();
    }
    
    private static void initializeSampleData() {
        Patient p1 = new Patient(101, "John Doe", 45, "0771234567", "Heart Disease");
        Patient p2 = new Patient(102, "Jane Smith", 32, "0772345678", "Fracture");
        Patient p3 = new Patient(103, "Bob Johnson", 60, "0773456789", "Diabetes");
        Patient p4 = new Patient(104, "Alice Brown", 28, "0774567890", "Asthma");
        Patient p5 = new Patient(105, "Charlie Wilson", 50, "0775678901", "Hypertension");
        
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);
        patientBST.insert(p4);
        patientBST.insert(p5);
        
        System.out.println("Sample data initialized!");
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
}