import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Course[] courses = new Course[100];
    private static int courseCount = 0;
    private static Student[] students = new Student[100];
    private static int studentCount = 0;
    private static Teacher[] teachers = new Teacher[50];
    private static int teacherCount = 0;

    public static void main(String[] args) {
        try {
            loadAllData();
            boolean running = true;
            while (running) {
                try {
                    displayMainMenu();
                    int choice = getIntInput("Enter your choice: ");
                    switch (choice) {
                        case 1: manageCourses(); break;
                        case 2: manageStudents(); break;
                        case 3: manageTeachers(); break;
                        case 4: displayAllInformation(); break;
                        case 5: saveAllData(); break;
                        case 6: loadAllData(); break;
                        case 7:
                            saveAllData();
                            running = false;
                            System.out.println("Thank you for using the Student Management System!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    System.out.println("Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
            System.out.println("The program will now exit.");
        } finally {
            scanner.close();
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Manage Courses");
        System.out.println("2. Manage Students");
        System.out.println("3. Manage Teachers");
        System.out.println("4. Display All Information");
        System.out.println("5. Save Data");
        System.out.println("6. Load Data");
        System.out.println("7. Save and Exit");
    }

    private static void manageCourses() {
        while (true) {
            try {
                System.out.println("\n=== Course Management ===");
                System.out.println("1. Add Course");
                System.out.println("2. List Courses");
                System.out.println("3. Back to Main Menu");
                
                int choice = getIntInput("Enter your choice: ");
                switch (choice) {
                    case 1:
                        try {
                            if (courseCount < courses.length) {
                                System.out.print("Enter course name: ");
                                String name = scanner.nextLine().trim();
                                if (name.isEmpty()) {
                                    throw new IllegalArgumentException("Course name cannot be empty");
                                }
                                int credits = getIntInput("Enter course credits: ");
                                if (credits <= 0) {
                                    throw new IllegalArgumentException("Credits must be greater than 0");
                                }
                                courses[courseCount] = new Course(name, credits);
                                courseCount++;
                                System.out.println("Course added successfully!");
                            } else {
                                throw new ArrayIndexOutOfBoundsException("Cannot add more courses. Maximum limit reached.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error adding course: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            if (courseCount > 0) {
                                System.out.println("\nList of Courses:");
                                for (int i = 0; i < courseCount; i++) {
                                    System.out.println((i + 1) + ". " + courses[i].getName() + " (" + courses[i].getCredits() + " credits)");
                                }
                            } else {
                                System.out.println("No courses available.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error displaying courses: " + e.getMessage());
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred in course management: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private static void manageStudents() {
        while (true) {
            try {
                System.out.println("\n=== Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. Back to Main Menu");
                
                int choice = getIntInput("Enter your choice: ");
                switch (choice) {
                    case 1:
                        try {
                            if (studentCount < students.length) {
                                System.out.print("Enter student name: ");
                                String name = scanner.nextLine().trim();
                                if (name.isEmpty()) {
                                    throw new IllegalArgumentException("Student name cannot be empty");
                                }
                                int age = getIntInput("Enter student age: ");
                                if (age <= 0 || age > 120) {
                                    throw new IllegalArgumentException("Invalid age. Age must be between 1 and 120");
                                }
                                System.out.print("Enter student grade: ");
                                String grade = scanner.nextLine().trim();
                                if (grade.isEmpty()) {
                                    throw new IllegalArgumentException("Grade cannot be empty");
                                }
                                students[studentCount] = new Student(name, age, grade);
                                studentCount++;
                                System.out.println("Student added successfully!");
                            } else {
                                throw new ArrayIndexOutOfBoundsException("Cannot add more students. Maximum limit reached.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error adding student: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            if (studentCount > 0) {
                                System.out.println("\nList of Students:");
                                for (int i = 0; i < studentCount; i++) {
                                    System.out.println((i + 1) + ". " + students[i].getName() + " (Age: " + students[i].getAge() + ")");
                                }
                            } else {
                                System.out.println("No students available.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error displaying students: " + e.getMessage());
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred in student management: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private static void manageTeachers() {
        while (true) {
            try {
                System.out.println("\n=== Teacher Management ===");
                System.out.println("1. Add Teacher");
                System.out.println("2. List Teachers");
                System.out.println("3. Back to Main Menu");
                
                int choice = getIntInput("Enter your choice: ");
                switch (choice) {
                    case 1:
                        try {
                            if (teacherCount < teachers.length) {
                                System.out.print("Enter teacher name: ");
                                String name = scanner.nextLine().trim();
                                if (name.isEmpty()) {
                                    throw new IllegalArgumentException("Teacher name cannot be empty");
                                }
                                int age = getIntInput("Enter teacher age: ");
                                if (age < 21 || age > 70) {
                                    throw new IllegalArgumentException("Invalid age. Age must be between 21 and 70");
                                }
                                double salary = getDoubleInput("Enter teacher salary: ");
                                if (salary <= 0) {
                                    throw new IllegalArgumentException("Salary must be greater than 0");
                                }
                                teachers[teacherCount] = new Teacher(name, age, salary);
                                teacherCount++;
                                System.out.println("Teacher added successfully!");
                            } else {
                                throw new ArrayIndexOutOfBoundsException("Cannot add more teachers. Maximum limit reached.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error adding teacher: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            if (teacherCount > 0) {
                                System.out.println("\nList of Teachers:");
                                for (int i = 0; i < teacherCount; i++) {
                                    System.out.println((i + 1) + ". " + teachers[i].getName() + " (Age: " + teachers[i].getAge() + ")");
                                }
                            } else {
                                System.out.println("No teachers available.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error displaying teachers: " + e.getMessage());
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred in teacher management: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private static void displayAllInformation() {
        System.out.println("\n=== All Information ===");
        
        System.out.println("\nCourses:");
        if (courseCount > 0) {
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + courses[i].getName() + " (" + courses[i].getCredits() + " credits)");
            }
        } else {
            System.out.println("No courses available.");
        }

        System.out.println("\nStudents:");
        if (studentCount > 0) {
            for (int i = 0; i < studentCount; i++) {
                System.out.println((i + 1) + ". " + students[i].getName() + " (Age: " + students[i].getAge() + ")");
            }
        } else {
            System.out.println("No students available.");
        }

        System.out.println("\nTeachers:");
        if (teacherCount > 0) {
            for (int i = 0; i < teacherCount; i++) {
                System.out.println((i + 1) + ". " + teachers[i].getName() + " (Age: " + teachers[i].getAge() + ")");
            }
        } else {
            System.out.println("No teachers available.");
        }
    }

    private static void saveAllData() {
        FileUtil.saveCourses(courses, courseCount);
        FileUtil.saveStudents(students, studentCount);
        FileUtil.saveTeachers(teachers, teacherCount);
    }

    private static void loadAllData() {
        courseCount = FileUtil.loadCourses(courses);
        studentCount = FileUtil.loadStudents(students);
        teacherCount = FileUtil.loadTeachers(teachers);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
