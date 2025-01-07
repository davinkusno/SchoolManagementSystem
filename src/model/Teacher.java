package model;

/**
 * Represents a teacher in the school.
 */
public class Teacher {

    private final int id;
    private final String name;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new teacher with a unique ID, name, and salary.
     *
     * @param id     the unique ID of the teacher.
     * @param name   the name of the teacher.
     * @param salary the salary of the teacher.
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    // Business Logic
    public void receiveSalary(int salary) {
        if (salary > 0) {
            salaryEarned += salary;
        }
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', salaryEarned=$" + salaryEarned + "}";
    }
}
