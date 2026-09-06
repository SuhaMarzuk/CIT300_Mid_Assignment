package com.hospital.datastructures;

import com.hospital.models.Visit;

public class SinglyLinkedList {
    private class Node {
        Visit visit;
        Node next;
        
        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    // Add a visit
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Visit added: " + visit);
    }
    
    // Remove a visit by ID
    public boolean removeVisit(int visitId) {
        if (head == null) return false;
        
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Search for a visit by ID
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }
    
    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history.");
            return;
        }
        
        Node current = head;
        System.out.println("--- Visit History ---");
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
        System.out.println("Total visits: " + size);
    }
    
    public int getSize() {
        return size;
    }
}