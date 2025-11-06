package com.mycompany.smsnetbeans;

public class Course {

    private String name;
    private int credits;
    private String id;
    private static int nextId = 1;

    // Constructor
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.id = "C" + nextId++;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        if (credits > 0) {
            this.credits = credits;
        }
    }

    // Display method
    public void display() {
        System.out.println("Course: " + name);
        System.out.println("ID: " + id);
        System.out.println("Credits: " + credits);
    }
}
