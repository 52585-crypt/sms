package com.mycompany.smsnetbeans;

import java.sql.*;
import javax.swing.JOptionPane;

public class FileUtil {

    // ----------------- COURSES -----------------
    // Save multiple courses
    public static void saveCourses(Course[] courses, int count) {
        String sql = "INSERT INTO courses (name, credits) VALUES (?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < count; i++) {
                stmt.setString(1, courses[i].getName());
                stmt.setInt(2, courses[i].getCredits());
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Courses saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving courses: " + e.getMessage());
        }
    }

    // Load multiple courses
    public static int loadCourses(Course[] courses) {
        int count = 0;
        String sql = "SELECT name, credits FROM courses";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next() && count < courses.length) {
                String name = rs.getString("name");
                int credits = rs.getInt("credits");
                courses[count++] = new Course(name, credits);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading courses: " + e.getMessage());
        }
        return count;
    }

    // Save single course
    public static boolean saveCourse(Course course) {
        String sql = "INSERT INTO courses (name, credits) VALUES (?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getCredits());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------- STUDENTS -----------------
    // Save multiple students
    public static void saveStudents(Student[] students, int count) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < count; i++) {
                stmt.setString(1, students[i].getName());
                stmt.setInt(2, students[i].getAge());
                stmt.setString(3, students[i].getGrade());
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Students saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving students: " + e.getMessage());
        }
    }

    // Load multiple students
    public static int loadStudents(Student[] students) {
        int count = 0;
        String sql = "SELECT name, age, grade FROM students";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next() && count < students.length) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                students[count++] = new Student(name, age, grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading students: " + e.getMessage());
        }
        return count;
    }

    // Save single student
    public static boolean saveStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------- TEACHERS -----------------
    // Save multiple teachers
    public static void saveTeachers(Teacher[] teachers, int count) {
        String sql = "INSERT INTO teachers (name, age, salary) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < count; i++) {
                stmt.setString(1, teachers[i].getName());
                stmt.setInt(2, teachers[i].getAge());
                stmt.setDouble(3, teachers[i].getSalary());
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Teachers saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving teachers: " + e.getMessage());
        }
    }

    // Load multiple teachers
    public static int loadTeachers(Teacher[] teachers) {
        int count = 0;
        String sql = "SELECT name, age, salary FROM teachers";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next() && count < teachers.length) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");
                teachers[count++] = new Teacher(name, age, salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading teachers: " + e.getMessage());
        }
        return count;
    }

    // Save single teacher
    public static boolean saveTeacher(Teacher teacher) {
        String sql = "INSERT INTO teachers (name, age, salary) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, teacher.getName());
            stmt.setInt(2, teacher.getAge());
            stmt.setDouble(3, teacher.getSalary());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
