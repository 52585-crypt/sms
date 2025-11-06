package com.mycompany.smsnetbeans;

public class Teacher extends Person {

    private Course[] teachingCourses;
    private int courseCount;
    private double salary;
    private static final int MAX_COURSES = 5;

    // Constructor
    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
        this.teachingCourses = new Course[MAX_COURSES];
        this.courseCount = 0;
    }

    // Add a course
    public boolean addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            teachingCourses[courseCount] = course;
            courseCount++;
            return true;
        } else {
            System.out.println("Cannot add more courses. Maximum limit reached.");
            return false;
        }
    }

    // Remove a course by ID
    public boolean removeCourse(String courseId) {
        for (int i = 0; i < courseCount; i++) {
            if (teachingCourses[i].getId().equals(courseId)) {
                for (int j = i; j < courseCount - 1; j++) {
                    teachingCourses[j] = teachingCourses[j + 1];
                }
                teachingCourses[courseCount - 1] = null;
                courseCount--;
                return true;
            }
        }
        return false;
    }

    // Getters and setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public int getCourseCount() {
        return courseCount;
    }

    public int getTotalTeachingCredits() {
        int total = 0;
        for (int i = 0; i < courseCount; i++) {
            total += teachingCourses[i].getCredits();
        }
        return total;
    }

    // Display teacher info
    @Override
    public void display() {
        super.display();
        System.out.println("Salary: $" + String.format("%.2f", salary));
        System.out.println("Teaching Courses (" + courseCount + "/" + MAX_COURSES + "):");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            teachingCourses[i].display();
        }
        System.out.println("Total Teaching Credits: " + getTotalTeachingCredits());
    }
}
