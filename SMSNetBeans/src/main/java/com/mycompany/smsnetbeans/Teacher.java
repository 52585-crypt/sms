package com.mycompany.smsnetbeans;

public class Teacher extends Person {

    private Course[] teachingCourses;
    private int courseCount;
    private double salary;
    private static final int MAX_COURSES = 5;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
        this.teachingCourses = new Course[MAX_COURSES];
        this.courseCount = 0;
    }

    public boolean addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            teachingCourses[courseCount++] = course;
            return true;
        }
        System.out.println("Cannot add more courses. Maximum limit reached.");
        return false;
    }

    public boolean removeCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (teachingCourses[i].getName().equals(courseName)) {
                for (int j = i; j < courseCount - 1; j++) {
                    teachingCourses[j] = teachingCourses[j + 1];
                }
                teachingCourses[--courseCount] = null;
                return true;
            }
        }
        return false;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { if (salary > 0) this.salary = salary; }
    public int getCourseCount() { return courseCount; }

    public int getTotalTeachingCredits() {
        int total = 0;
        for (int i = 0; i < courseCount; i++) total += teachingCourses[i].getCredits();
        return total;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salary: $" + String.format("%.2f", salary));
        System.out.println("Teaching Courses (" + courseCount + "/" + MAX_COURSES + "):");
        for (int i = 0; i < courseCount; i++) teachingCourses[i].display();
        System.out.println("Total Teaching Credits: " + getTotalTeachingCredits());
    }
}
