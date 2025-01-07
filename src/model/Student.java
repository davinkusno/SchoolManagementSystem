package model;

/**
 * Represents a student in the school.
 */
public class Student {

    private final int id;
    private final String name;
    private int grade;
    private int feesPaid;
    private final int feesTotal;

    /**
     * Creates a new student with a unique ID, name, and grade.
     * The total fees for every student is $30,000.
     *
     * @param id    the unique ID of the student.
     * @param name  the name of the student.
     * @param grade the grade of the student.
     */
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 30000;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade > 0) {
            this.grade = grade;
        }
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    // Business Logic
    public void payFees(int fees) {
        if (fees > 0 && (feesPaid + fees <= feesTotal)) {
            feesPaid += fees;
        }
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', feesPaid=$" + feesPaid + "}";
    }

    public String getDescription() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}
