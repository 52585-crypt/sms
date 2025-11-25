package com.mycompany.smsnetbeans;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    public MainGUI() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton btnCourses = new JButton("Manage Courses");
        JButton btnStudents = new JButton("Manage Students");
        JButton btnTeachers = new JButton("Manage Teachers");
        JButton btnDisplay = new JButton("Display All info");
        JButton btnSave = new JButton("Save Data");
        JButton btnLoad = new JButton("Load Data");

        btnCourses.addActionListener(e -> new CourseGUI());
        btnStudents.addActionListener(e -> new StudentGUI());
        btnTeachers.addActionListener(e -> new TeacherGUI());
        btnDisplay.addActionListener(e -> displayAllInfo());
        btnSave.addActionListener(e -> saveAllData());
        btnLoad.addActionListener(e -> loadAllData());

        mainPanel.add(btnCourses);
        mainPanel.add(btnStudents);
        mainPanel.add(btnTeachers);
        mainPanel.add(btnDisplay);
        mainPanel.add(btnSave);
        mainPanel.add(btnLoad);

        add(mainPanel);
    }

    private void displayAllInfo() {
        JOptionPane.showMessageDialog(this,
                "Display all Courses, Students, and Teachers here.",
                "All Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveAllData() {
        FileUtil.saveCourses(Main.courses, Main.courseCount);
        FileUtil.saveStudents(Main.students, Main.studentCount);
        FileUtil.saveTeachers(Main.teachers, Main.teacherCount);
        JOptionPane.showMessageDialog(this, "All data saved successfully!");
    }

    private void loadAllData() {
        Main.courseCount = FileUtil.loadCourses(Main.courses);
        Main.studentCount = FileUtil.loadStudents(Main.students);
        Main.teacherCount = FileUtil.loadTeachers(Main.teachers);
        JOptionPane.showMessageDialog(this, "All data loaded successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI());
    }
}
