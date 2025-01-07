package iterator;

import java.util.List;
import model.Teacher;

public class TeacherIterator implements Iterator<Teacher> {
    private List<Teacher> teachers;
    private int position;

    public TeacherIterator(List<Teacher> teachers) {
        this.teachers = teachers;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < teachers.size();
    }

    @Override
    public Teacher next() {
        if (!hasNext()) {
            return null;
        }
        return teachers.get(position++);
    }
}
