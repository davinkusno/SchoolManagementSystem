package decorator;

import model.Student;

/**
 * Adds a sports club membership to a Student.
 */
public class SportsClubMembership extends StudentDecorator {
    private final int membershipFee = 2000;

    public SportsClubMembership(Student student) {
        super(student);
    }

    @Override
    public int getFeesTotal() {
        return super.getFeesTotal() + membershipFee;
    }

    @Override
    public String getDescription() {
        return super.toString() + ", Sports Club Member";
    }
}
