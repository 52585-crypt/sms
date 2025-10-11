# Student Management System

A console-based Java application for managing students, teachers, and courses in an educational institution.

## Features

### 1. Course Management
- Add new courses with name and credits
- Display all courses
- Search courses by ID
- Automatic course ID generation (C1, C2, etc.)

### 2. Student Management
- Add new students with name, age, and grade
- Display all students
- Add/remove courses for students
- Search students by ID
- View enrolled courses and total credits
- Automatic student ID generation (P1, P2, etc.)

### 3. Teacher Management
- Add new teachers with name, age, and salary
- Display all teachers
- Assign/remove courses for teachers
- Search teachers by ID
- View assigned courses
- Automatic teacher ID generation (P1, P2, etc.)

### 4. System Information
- View complete system statistics
- Display all courses, students, and teachers
- Show relationships between entities

## Project Structure

```
src/
├── Course.java      # Course class definition
├── Person.java      # Base class for Student and Teacher
├── Student.java     # Student class (extends Person)
├── Teacher.java     # Teacher class (extends Person)
└── Main.java        # Main application with console interface
```

## Class Hierarchy

- `Person`: Base class with common attributes (name, age, ID)
  - `Student`: Extends Person, adds grade and course enrollment
  - `Teacher`: Extends Person, adds salary and course assignment

## How to Run

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the main class:
   ```bash
   java Main
   ```

## Usage Guide

1. **Main Menu Options**:
   - 1: Manage Courses
   - 2: Manage Students
   - 3: Manage Teachers
   - 4: Display All Information
   - 5: Exit

2. **Course Management**:
   - Add new courses
   - View all courses
   - Search by course ID

3. **Student Management**:
   - Register new students
   - Enroll students in courses
   - Remove courses from students
   - View student details

4. **Teacher Management**:
   - Register new teachers
   - Assign courses to teachers
   - Remove course assignments
   - View teacher details

## Input Validation

- Age must be positive
- Credits must be positive
- Salary must be positive
- IDs are automatically generated
- Maximum limits:
  - 100 courses
  - 100 students
  - 50 teachers
  - 10 courses per student/teacher

## Data Management

- Uses arrays for data storage
- Automatic ID generation
- Relationship management between entities
- Input validation and error handling

## Contributors

This project was created as part of the Advanced Computer Programming course.