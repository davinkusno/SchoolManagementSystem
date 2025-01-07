package iterator;

import java.util.List;
import model.Student;

public class StudentCollection implements IterableCollection<Student> {
    private List<Student> students;

    public StudentCollection(List<Student> students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> createIterator() {
        return new StudentIterator(students);
    }
}
