package decorator;

import model.Student;

/**
 * Adds a scholarship benefit to a Student.
 */
public class Scholarship extends StudentDecorator {
    private final int scholarshipAmount;

    public Scholarship(Student student, int scholarshipAmount) {
        super(student);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public int getFeesTotal() {
        return super.getFeesTotal() - scholarshipAmount;
    }

    @Override
    public String getDescription() {
        return super.toString() + ", Scholarship Awardee";
    }
}
