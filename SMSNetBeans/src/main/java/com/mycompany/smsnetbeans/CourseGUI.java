package com.mycompany.smsnetbeans;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseGUI extends JFrame {

    private JTextField txtCourseName, txtCreditHours;
    private JButton btnAdd, btnClear, btnBack;
    private JTextArea txtDisplayArea;

    public CourseGUI() {
        setTitle("Manage Courses");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel lblCourseName = new JLabel("Course Name:");
        JLabel lblCreditHours = new JLabel("Credit Hours:");

        txtCourseName = new JTextField();
        txtCreditHours = new JTextField();

        formPanel.add(lblCourseName);
        formPanel.add(txtCourseName);
        formPanel.add(lblCreditHours);
        formPanel.add(txtCreditHours);

        btnAdd = new JButton("Add Course");
        btnClear = new JButton("Clear");
        btnBack = new JButton("Back");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnBack);

        txtDisplayArea = new JTextArea();
        txtDisplayArea.setEditable(false);
        txtDisplayArea.setBorder(BorderFactory.createTitledBorder("Added Courses"));
        JScrollPane scrollPane = new JScrollPane(txtDisplayArea);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);

        btnAdd.addActionListener(e -> addCourse());
        btnClear.addActionListener(e -> clearFields());
        btnBack.addActionListener(e -> dispose());
    }

    private void addCourse() {
        String name = txtCourseName.getText().trim();
        String creditsStr = txtCreditHours.getText().trim();

        if (name.isEmpty() || creditsStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int credits;
        try {
            credits = Integer.parseInt(creditsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Credits must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Course course = new Course(name, credits);

        if (saveCourseToDB(course)) {
            txtDisplayArea.append("Course Added: " + name + " (" + credits + " Credits)\n");
            JOptionPane.showMessageDialog(this, "Course Added Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save course to DB.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        clearFields();
    }

    private boolean saveCourseToDB(Course course) {
        String sql = "INSERT INTO courses (name, credits) VALUES (?, ?)";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, course.getName());
            ps.setInt(2, course.getCredits());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void clearFields() {
        txtCourseName.setText("");
        txtCreditHours.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourseGUI::new);
    }
}
