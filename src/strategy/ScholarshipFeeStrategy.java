package strategy;

import model.Student;

public class ScholarshipFeeStrategy implements FeeCalculationStrategy {
    private final int scholarshipAmount;

    public ScholarshipFeeStrategy(int scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public int calculateFee(Student student) {
        return Math.max(student.getFeesTotal() - scholarshipAmount, 0);
    }
}