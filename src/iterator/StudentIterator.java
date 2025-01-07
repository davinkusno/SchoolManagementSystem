package iterator;

import java.util.List;
import model.Student;

public class StudentIterator implements Iterator<Student> {
    private List<Student> students;
    private int position;

    public StudentIterator(List<Student> students) {
        this.students = students;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            return null;
        }
        return students.get(position++);
    }
}
