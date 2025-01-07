package model;

import singleton.Finance;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a school that manages teachers, students, and finances.
 */
public class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private Finance finance;

    /**
     * Creates a new School object with lists of teachers and students
     * and initializes financial tracking.
     *
     * @param teachers list of teachers in the school.
     * @param students list of students in the school.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = new ArrayList<>(teachers);
        this.students = new ArrayList<>(students);
        this.finance = Finance.getInstance();
    }

    // Getters
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Finance getFinance() {
        return finance;
    }

    /**
     * Adds a teacher to the school.
     *
     * @param teacher the teacher to be added.
     */
    public void addTeacher(Teacher teacher) {
        if (teacher != null) {
            teachers.add(teacher);
        }
    }

    /**
     * Adds a student to the school.
     *
     * @param student the student to be added.
     */
    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    @Override
    public String toString() {
        return "School: \nTeachers: " + teachers.size() +
               "\nStudents: " + students.size() +
               "\n" + finance.toString();
    }

    public String getTotalMoneyEarned() {
        return "get total money earned function";
    }
}
