import java.io.*;

public class FileUtil {
    // File names for storing data
    private static final String COURSE_FILE = "courses.txt";
    private static final String STUDENT_FILE = "students.txt";
    private static final String TEACHER_FILE = "teachers.txt";

    // Save courses to file
    public static void saveCourses(Course[] courses, int count) {
        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(COURSE_FILE);

            // First write the count of courses
            writer.write(count + "\n");

            // Write each course's data
            for (int i = 0; i < count; i++) {
                Course course = courses[i];
                // Format: name,credits
                writer.write(course.getName() + "," + course.getCredits() + "\n");
            }

            // Close the writer
            writer.close();
            System.out.println("Courses saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // Save students to file
    public static void saveStudents(Student[] students, int count) {
        try {
            FileWriter writer = new FileWriter(STUDENT_FILE);
            writer.write(count + "\n");
            
            for (int i = 0; i < count; i++) {
                Student student = students[i];
                // Format: name,age,grade
                writer.write(student.getName() + "," + 
                           student.getAge() + "," + 
                           student.getGrade() + "\n");
            }
            
            writer.close();
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Save teachers to file
    public static void saveTeachers(Teacher[] teachers, int count) {
        try {
            FileWriter writer = new FileWriter(TEACHER_FILE);
            writer.write(count + "\n");
            
            for (int i = 0; i < count; i++) {
                Teacher teacher = teachers[i];
                // Format: name,age,salary
                writer.write(teacher.getName() + "," + 
                           teacher.getAge() + "," + 
                           teacher.getSalary() + "\n");
            }
            
            writer.close();
            System.out.println("Teachers saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving teachers: " + e.getMessage());
        }
    }

    // Load courses from file
    public static int loadCourses(Course[] courses) {
        try {
            File file = new File(COURSE_FILE);
            if (!file.exists()) {
                return 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            // Read the count from first line
            int count = Integer.parseInt(reader.readLine());
            
            // Read each course
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int credits = Integer.parseInt(parts[1]);
                courses[i] = new Course(name, credits);
            }
            
            reader.close();
            System.out.println("Courses loaded successfully!");
            return count;
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading courses: " + e.getMessage());
            return 0;
        }
    }

    // Load students from file
    public static int loadStudents(Student[] students) {
        try {
            File file = new File(STUDENT_FILE);
            if (!file.exists()) {
                return 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = Integer.parseInt(reader.readLine());
            
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String grade = parts[2];
                students[i] = new Student(name, age, grade);
            }
            
            reader.close();
            System.out.println("Students loaded successfully!");
            return count;
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students: " + e.getMessage());
            return 0;
        }
    }

    // Load teachers from file
    public static int loadTeachers(Teacher[] teachers) {
        try {
            File file = new File(TEACHER_FILE);
            if (!file.exists()) {
                return 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = Integer.parseInt(reader.readLine());
            
            for (int i = 0; i < count; i++) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                double salary = Double.parseDouble(parts[2]);
                teachers[i] = new Teacher(name, age, salary);
            }
            
            reader.close();
            System.out.println("Teachers loaded successfully!");
            return count;
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
            return 0;
        }
    }
}