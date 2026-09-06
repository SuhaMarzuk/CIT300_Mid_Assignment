package com.hospital.datastructures;

import com.hospital.models.Patient;

public class Stack {
    private class Node {
        Patient patient;
        Node next;
        
        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }
    
    private Node top;
    private int size;
    
    public Stack() {
        top = null;
        size = 0;
    }
    
    // Push - add treatment record
    public void push(Patient patient) {
        Node newNode = new Node(patient);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Treatment completed for: " + patient.getName());
    }
    
    // Pop - remove most recent
    public Patient pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No treatment records.");
            return null;
        }
        
        Patient patient = top.patient;
        top = top.next;
        size--;
        System.out.println("Removed treatment record for: " + patient.getName());
        return patient;
    }
    
    // Display all treatment records (most recent first)
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records.");
            return;
        }
        
        Node current = top;
        System.out.println("--- Treatment History (Most Recent First) ---");
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
        System.out.println("Total treatments: " + size);
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int getSize() {
        return size;
    }
}