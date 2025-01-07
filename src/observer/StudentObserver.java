package observer;

import model.Student;

import java.util.List;

public class StudentObserver implements Observer {
    private final List<Student> students;

    public StudentObserver(List<Student> students) {
        this.students = students;
    }

    @Override
    public void update() {
        System.out.println("Students Updated: " + students);
    }
}