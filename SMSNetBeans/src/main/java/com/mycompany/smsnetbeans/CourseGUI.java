
package com.mycompany.smsnetbeans;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CourseGUI extends JFrame {
    private JTextField txtCourseId,txtCourseName,txtCreditHours;
    private JButton btnAdd,btnClear,btnBack;
    private JTextArea txtDisplayArea;
    
    public CourseGUI(){
         setTitle("Manage Courses");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        initComponents();
        setVisible(true);
    }
      private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel lblCourseId = new JLabel("Course ID:");
        JLabel lblCourseName = new JLabel("Course Name:");
        JLabel lblCreditHours = new JLabel("Credit Hours:");

        txtCourseId = new JTextField();
        txtCourseName = new JTextField();
        txtCreditHours = new JTextField();

        formPanel.add(lblCourseId);
        formPanel.add(txtCourseId);
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
        String id = txtCourseId.getText().trim();
        String name = txtCourseName.getText().trim();
        String credits = txtCreditHours.getText().trim();

        if (id.isEmpty() || name.isEmpty() || credits.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        txtDisplayArea.append("Course Added: " + id + " - " + name + " (" + credits + " Credits)\n");
        JOptionPane.showMessageDialog(this, "Course Added Successfully!");
        clearFields();
    }

    private void clearFields() {
        txtCourseId.setText("");
        txtCourseName.setText("");
        txtCreditHours.setText("");
    }
}
