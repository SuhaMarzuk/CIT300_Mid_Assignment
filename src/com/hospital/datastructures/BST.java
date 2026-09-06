package com.hospital.datastructures;

import com.hospital.models.Patient;

public class BST {
    // Node class inside BST
    private class Node {
        Patient patient;
        Node left, right;
        
        Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }
    
    private Node root;
    
    // Insert a patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }
    
    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }
        
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        }
        return root;
    }
    
    // Search for a patient
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }
    
    private Patient searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root == null ? null : root.patient;
        }
        
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }
    
    // Delete a patient
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }
    
    private Node deleteRec(Node root, int patientId) {
        if (root == null) return null;
        
        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Node with two children: get inorder successor
            Node successor = findMin(root.right);
            root.patient = successor.patient;
            root.right = deleteRec(root.right, successor.patient.getPatientId());
        }
        return root;
    }
    
    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    // In-order traversal
    public void inOrderTraversal() {
        inOrderRec(root);
    }
    
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}