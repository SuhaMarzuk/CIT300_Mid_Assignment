package com.hospital.datastructures;

import com.hospital.models.Patient;

public class Queue {
    private class Node {
        Patient patient;
        Node next;
        
        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }
    
    private Node front, rear;
    private int size;
    
    public Queue() {
        front = rear = null;
        size = 0;
    }
    
    // Enqueue - add patient
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }
    
    // Dequeue - remove patient
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No patients to treat.");
            return null;
        }
        
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Patient " + patient.getName() + " removed from queue for treatment.");
        return patient;
    }
    
    // Display all patients in queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        
        Node current = front;
        System.out.println("--- Emergency Queue ---");
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
        System.out.println("Total: " + size + " patients waiting.");
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public int getSize() {
        return size;
    }
}