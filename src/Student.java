public class Student extends Person {
    private Course[] courses;
    private int courseCount;
    private String grade;
    private static final int MAX_COURSES = 10;
    
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
        this.courses = new Course[MAX_COURSES];
        this.courseCount = 0;
    }
    
    public boolean addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            courses[courseCount] = course;
            courseCount++;
            return true;
        } else {
            System.out.println("Cannot add more courses. Maximum limit reached.");
            return false;
        }
    }
    
    public boolean removeCourse(String courseId) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getId().equals(courseId)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[courseCount - 1] = null;
                courseCount--;
                return true;
            }
        }
        return false;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public int getCourseCount() {
        return courseCount;
    }
    
    public int getTotalCredits() {
        int total = 0;
        for (int i = 0; i < courseCount; i++) {
            total += courses[i].getCredits();
        }
        return total;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Grade: " + grade);
        System.out.println("Courses (" + courseCount + "/" + MAX_COURSES + "):");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            courses[i].display();
        }
        System.out.println("Total Credits: " + getTotalCredits());
    }
}