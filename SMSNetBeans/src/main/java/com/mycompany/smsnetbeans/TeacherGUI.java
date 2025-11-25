package com.mycompany.smsnetbeans;

import javax.swing.*;
import java.awt.*;

public class TeacherGUI extends JFrame {

    private JTextField txtTeacherName, txtSubject, txtSalary;
    private JComboBox<String> cbQualification;
    private JButton btnAdd, btnClear, btnBack;
    private JTextArea txtDisplayArea;

    public TeacherGUI() {
        setTitle("Manage Teachers");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel lblName = new JLabel("Name:");
        JLabel lblSubject = new JLabel("Subject:");
        JLabel lblQual = new JLabel("Qualification:");
        JLabel lblSalary = new JLabel("Salary:");

        txtTeacherName = new JTextField();
        txtSubject = new JTextField();
        txtSalary = new JTextField();

        cbQualification = new JComboBox<>(new String[]{"BS", "MS", "PhD"});

        formPanel.add(lblName); formPanel.add(txtTeacherName);
        formPanel.add(lblSubject); formPanel.add(txtSubject);
        formPanel.add(lblQual); formPanel.add(cbQualification);
        formPanel.add(lblSalary); formPanel.add(txtSalary);

        btnAdd = new JButton("Add Teacher");
        btnClear = new JButton("Clear");
        btnBack = new JButton("Back");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnBack);

        txtDisplayArea = new JTextArea();
        txtDisplayArea.setEditable(false);
        txtDisplayArea.setBorder(BorderFactory.createTitledBorder("Teacher Records"));
        JScrollPane scrollPane = new JScrollPane(txtDisplayArea);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);

        btnAdd.addActionListener(e -> addTeacher());
        btnClear.addActionListener(e -> clearFields());
        btnBack.addActionListener(e -> dispose());
    }

    private void addTeacher() {
        String name = txtTeacherName.getText().trim();
        String subject = txtSubject.getText().trim();
        String qual = cbQualification.getSelectedItem().toString();
        String salaryStr = txtSalary.getText().trim();

        if (name.isEmpty() || subject.isEmpty() || salaryStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salary must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Teacher teacher = new Teacher(name, 0, salary); // Age can be optional
        teacher.setSalary(salary);

        if (FileUtil.saveTeacher(teacher)) {
            txtDisplayArea.append(name + " (" + subject + ", " + qual + ", $" + salary + ")\n");
            JOptionPane.showMessageDialog(this, "Teacher Added Successfully!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add teacher to database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtTeacherName.setText("");
        txtSubject.setText("");
        txtSalary.setText("");
        cbQualification.setSelectedIndex(0);
    }
}
