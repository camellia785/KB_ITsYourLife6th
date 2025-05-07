package advanced.ch15.sec05.exercise;

public class Student implements Comparable<Student>{
    public int id;
    public String name;
    public String email;
    public String github;

    public Student(int id, String name, String email, String github) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.github = github;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
