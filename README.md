# Patient Management System

## Overview
This is a console-based Patient Management System built in Java for the DSA Mid-Term Sprint
The program uses:
- Queue data structure for a patient waiting room
- Doubly Linked List for patient history navigation
- Unit testing using JUnit

## Features

### Part 1: Patient Waiting Room
- Add a patient to the queue
- Serve the next patient
- Insert an emergency patient at a specific position
- Print all patients currently in the queue
- Handle empty queue situations safely

### Part 2: Patient History System
- Includes at least 10 patient history records
- Navigate to next record
- Navigate to previous record
- Display the newest record
- Display the oldest record
- Prevent navigation past head or tail

## Classes
- `Patient` - stores patient waiting room data
- `PatientQueue` - manages the waiting room queue
- `PatientRecord` - stores patient history data
- `PatientHistory` - custom doubly linked list for record navigation
- `Main` - scanner-based console menu
- `PatientManagementSystemTest` - unit tests

## Unit Tests
The unit tests I made:
1. Test serving from an empty queue
2. Test emergency patient insertion at correct position
3. Test preventing movement before the oldest history record
4. Test correct oldest and newest record retrieval

## How to Run
1. Open the project in IntelliJ IDEA
2. Load Maven dependencies
3. Run `Main.java`
4. Use the console menu to test all features

## Author
Christopher King

### Part 3: Documentation Questions.
1. A Queue was the proper thing for the waiting room patients are normally served in order of arrival unless emergencies
occur, the queue makes it easy to add patients to the rear of the queue while also removing them from the front in an 
organized way.
2. FIFO is defined as First In, First Out. It means the first thing added into a queue will be the first thing removed 
from the queue.
3. When a stack is used in a project like this, the waiting room would behave unfairly. A stack follows LIFO which mean Last
In, Last Out, so the most recent patients would be seen first, leaving the longest waiters waiting longer than they should.
4. There are several ways to improve this system, such as adding a search functionality using patient ID or Name, Or setting 
up a database and connecting it to the system to store and backup patient data.
5. A doubly linked list is appropriate for patient history because it allows movement in both directions depending on the needs
of the user. Since each node is referencing both the next and previous node, there is no need to return to the beginning to search.
6. If the next and previous pointers are not updated correctly, the linked list can brake. Records might be undetectable, navigation
might skip records, or the program could fail while attempting to move forwards or backwards.
7. A doubly linked list works well in this case because it is designed for navigation between connected records. Each node knows
the previous and next record, so moving forward and backwards is easy. With an array, you can still do this, but the structure
is not known to be built around linked navigation, A doubly linked list represents a chain of records more directly.