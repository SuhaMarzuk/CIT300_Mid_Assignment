package com.hospital.models;

import com.hospital.datastructures.SinglyLinkedList;

public class Patient {
    // Attributes
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private SinglyLinkedList visitHistory; // For Part 4
    
    // Constructor
    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new SinglyLinkedList();
    }
    
    // Getters and Setters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalCondition() { return medicalCondition; }
    public SinglyLinkedList getVisitHistory() { return visitHistory; }
    
    // Display patient info
    @Override
    public String toString() {
        return "ID: " + patientId + 
               ", Name: " + name + 
               ", Age: " + age + 
               ", Contact: " + contactNumber + 
               ", Condition: " + medicalCondition;
    }
}