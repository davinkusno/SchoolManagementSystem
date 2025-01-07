package observer;

import model.Teacher;

import java.util.List;

public class TeacherObserver implements Observer {
    private final List<Teacher> teachers;

    public TeacherObserver(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void update() {
        System.out.println("Teachers Updated: " + teachers);
    }
}