# CIT300 Mid Assignment — Hospital Management System

A console-based Hospital Management System implemented in Java, built to demonstrate
core data structures and object-oriented design.

## Project Structure

```
CIT300_Mid_Assignment/
├── src/
│   └── com/
│       └── hospital/
│           ├── models/
│           │   ├── Patient.java
│           │   └── Visit.java
│           ├── datastructures/
│           │   ├── BST.java
│           │   ├── Queue.java
│           │   ├── Stack.java
│           │   └── SinglyLinkedList.java
│           └── Main.java
├── README.md
└── .gitignore
```

## Project Overview
This is a hospital management system implementing four core data structures:
- Binary Search Tree (BST) for patient records
- Queue for emergency patient management
- Stack for treatment history
- Singly Linked List for patient visit history

## Components

- **Patient** — model representing a registered hospital patient (ID, name, age, gender, contact).
- **Visit** — model representing a single visit/appointment record.
- **BST** — binary search tree storing `Patient` records keyed by patient ID, enabling fast
  insert, search, delete, and sorted (in-order) listing.
- **Queue** — FIFO structure managing the line of patients waiting to be seen.
- **Stack** — LIFO structure keeping the most recent visit history readily accessible.
- **SinglyLinkedList** — stores the complete, chronological visit log.
- **Main** — menu-driven console application tying all the above together.

## How to Compile and Run

From the project root:

```bash
# Compile
javac -d out $(find src -name "*.java")

# Run
java -cp out com.hospital.Main
```

## Features

1. Register a new patient
2. Search for a patient by ID
3. Delete a patient record
4. List all patients sorted by ID
5. Add a patient to the waiting queue
6. Serve the next patient in the queue (records a visit)
7. View the current waiting queue
8. View recent visit history (stack, most recent first)
9. View the full visit log (chronological order)
0. Exit

## Author

Suha Marzuk
23DA2-0488
