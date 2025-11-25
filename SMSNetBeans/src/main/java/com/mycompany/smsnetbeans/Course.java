package com.mycompany.smsnetbeans;

public class Course {

    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }

    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { if (credits > 0) this.credits = credits; }

    public void display() {
        System.out.println("Course: " + name);
        System.out.println("Credits: " + credits);
    }
}
