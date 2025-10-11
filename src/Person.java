public class Person {
    protected String name;
    protected int age;
    protected String id;
    private static int nextId = 1;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = "P" + nextId++;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
    }
}