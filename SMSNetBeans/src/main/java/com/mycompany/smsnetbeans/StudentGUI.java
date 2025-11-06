package com.mycompany.smsnetbeans;

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {
    
    private JTextField txtStudentId, txtStudentName, txtStudentAge;
    private JComboBox<String> cbDepartment;
    private JRadioButton rbMale, rbFemale;
    private JButton btnAdd, btnClear, btnBack;
    private JTextArea txtDisplayArea;
    private ButtonGroup genderGroup;

    public StudentGUI() {
        setTitle("Manage Students");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Labels and Fields
        JLabel lblId = new JLabel("Student ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblAge = new JLabel("Age:");
        JLabel lblGender = new JLabel("Gender:");
        JLabel lblDept = new JLabel("Department:");

        txtStudentId = new JTextField();
        txtStudentName = new JTextField();
        txtStudentAge = new JTextField();

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        JPanel genderPanel = new JPanel();
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        cbDepartment = new JComboBox<>(new String[]{"Computer Science", "Software Engineering", "IT", "AI"});

        // Add to form panel
        formPanel.add(lblId); formPanel.add(txtStudentId);
        formPanel.add(lblName); formPanel.add(txtStudentName);
        formPanel.add(lblAge); formPanel.add(txtStudentAge);
        formPanel.add(lblGender); formPanel.add(genderPanel);
        formPanel.add(lblDept); formPanel.add(cbDepartment);

        // Buttons
        btnAdd = new JButton("Add Student");
        btnClear = new JButton("Clear");
        btnBack = new JButton("Back");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnBack);

        // Display area
        txtDisplayArea = new JTextArea();
        txtDisplayArea.setEditable(false);
        txtDisplayArea.setBorder(BorderFactory.createTitledBorder("Student Records"));
        JScrollPane scrollPane = new JScrollPane(txtDisplayArea);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);

        // Actions
        btnAdd.addActionListener(e -> addStudent());
        btnClear.addActionListener(e -> clearFields());
        btnBack.addActionListener(e -> dispose());
    }

    private void addStudent() {
        String id = txtStudentId.getText().trim();
        String name = txtStudentName.getText().trim();
        String age = txtStudentAge.getText().trim();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "";
        String dept = cbDepartment.getSelectedItem().toString();

        if (id.isEmpty() || name.isEmpty() || age.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        txtDisplayArea.append(id + " - " + name + " (" + gender + ", " + dept + ")\n");
        JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        clearFields();
    }

    private void clearFields() {
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtStudentAge.setText("");
        genderGroup.clearSelection();
        cbDepartment.setSelectedIndex(0);
    }
}
