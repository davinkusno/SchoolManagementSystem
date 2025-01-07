package strategy;

import model.Student;

public interface FeeCalculationStrategy {
    int calculateFee(Student student);
}
