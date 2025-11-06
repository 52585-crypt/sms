package com.mycompany.smsnetbeans;

import javax.swing.*;
import java.awt.*;

public class TeacherGUI extends JFrame {

    private JTextField txtTeacherId, txtTeacherName, txtSubject;
    private JComboBox<String> cbQualification;
    private JButton btnAdd, btnClear, btnBack;
    private JTextArea txtDisplayArea;

    public TeacherGUI() {
        setTitle("Manage Teachers");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel lblId = new JLabel("Teacher ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblSubject = new JLabel("Subject:");
        JLabel lblQual = new JLabel("Qualification:");

        txtTeacherId = new JTextField();
        txtTeacherName = new JTextField();
        txtSubject = new JTextField();

        cbQualification = new JComboBox<>(new String[]{"BS", "MS", "PhD"});

        formPanel.add(lblId); formPanel.add(txtTeacherId);
        formPanel.add(lblName); formPanel.add(txtTeacherName);
        formPanel.add(lblSubject); formPanel.add(txtSubject);
        formPanel.add(lblQual); formPanel.add(cbQualification);

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
        String id = txtTeacherId.getText().trim();
        String name = txtTeacherName.getText().trim();
        String subject = txtSubject.getText().trim();
        String qual = cbQualification.getSelectedItem().toString();

        if (id.isEmpty() || name.isEmpty() || subject.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        txtDisplayArea.append(id + " - " + name + " (" + subject + ", " + qual + ")\n");
        JOptionPane.showMessageDialog(this, "Teacher Added Successfully!");
        clearFields();
    }

    private void clearFields() {
        txtTeacherId.setText("");
        txtTeacherName.setText("");
        txtSubject.setText("");
        cbQualification.setSelectedIndex(0);
    }
}
