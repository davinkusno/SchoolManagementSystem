package strategy;

import model.Student;

public class RegularFeeStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateFee(Student student) {
        return student.getFeesTotal();
    }
}