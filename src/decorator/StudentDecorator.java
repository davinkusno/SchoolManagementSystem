package decorator;

import model.Student;

/**
 * Abstract decorator for adding responsibilities to a Student.
 */
public abstract class StudentDecorator extends Student {
    protected Student student;

    public StudentDecorator(Student student) {
        super(student.getId(), student.getName(), student.getGrade());
        this.student = student;
    }

    @Override
    public int getFeesTotal() {
        return student.getFeesTotal();
    }

    @Override
    public int getFeesPaid() {
        return student.getFeesPaid();
    }

    @Override
    public int getRemainingFees() {
        return student.getRemainingFees();
    }

    @Override
    public String toString() {
        return student.toString();
    }
}
