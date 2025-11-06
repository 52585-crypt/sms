package com.mycompany.smsnetbeans;

import java.io.*;

public class FileUtil {

    // File names for storing data
    private static final String COURSE_FILE = "courses.txt";
    private static final String STUDENT_FILE = "students.txt";
    private static final String TEACHER_FILE = "teachers.txt";

    // Save courses to file
    public static void saveCourses(Course[] courses, int count) {
        try (FileWriter writer = new FileWriter(COURSE_FILE)) {
            writer.write(count + "\n");
            for (int i = 0; i < count; i++) {
                Course course = courses[i];
                writer.write(course.getName() + "," + course.getCredits() + "\n");
            }
            System.out.println("Courses saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // Save students to file
    public static void saveStudents(Student[] students, int count) {
        try (FileWriter writer = new FileWriter(STUDENT_FILE)) {
            writer.write(count + "\n");
            for (int i = 0; i < count; i++) {
                Student student = students[i];
                writer.write(student.getName() + "," + student.getAge() + "," + student.getGrade() + "\n");
            }
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Save teachers to file
    public static void saveTeachers(Teacher[] teachers, int count) {
        try (FileWriter writer = new FileWriter(TEACHER_FILE)) {
            writer.write(count + "\n");
            for (int i = 0; i < count; i++) {
                Teacher teacher = teachers[i];
                writer.write(teacher.getName() + "," + teacher.getAge() + "," + teacher.getSalary() + "\n");
            }
            System.out.println("Teachers saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }

    // Load courses from file
    public static int loadCourses(Course[] courses) {
        File file = new File(COURSE_FILE);
        if (!file.exists()) return 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] parts = reader.readLine().split(",");
                courses[i] = new Course(parts[0], Integer.parseInt(parts[1]));
            }
            System.out.println("Courses loaded successfully!");
            return count;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading courses: " + e.getMessage());
            return 0;
        }
    }

    // Load students from file
    public static int loadStudents(Student[] students) {
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] parts = reader.readLine().split(",");
                students[i] = new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
            }
            System.out.println("Students loaded successfully!");
            return count;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students: " + e.getMessage());
            return 0;
        }
    }

    // Load teachers from file
    public static int loadTeachers(Teacher[] teachers) {
        File file = new File(TEACHER_FILE);
        if (!file.exists()) return 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] parts = reader.readLine().split(",");
                teachers[i] = new Teacher(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
            }
            System.out.println("Teachers loaded successfully!");
            return count;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
            return 0;
        }
    }
}
