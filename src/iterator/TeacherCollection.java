package iterator;

import java.util.List;
import model.Teacher;

public class TeacherCollection implements IterableCollection<Teacher> {
    private List<Teacher> teachers;

    public TeacherCollection(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public Iterator<Teacher> createIterator() {
        return new TeacherIterator(teachers);
    }
}
