package facade;

import command.*;
import factory.StudentFactory;
import factory.TeacherFactory;
import model.School;
import model.Student;
import model.Teacher;
import singleton.Finance;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for simplifying interactions with the school management system.
 */
public class SchoolFacade {
    private final School school;
    private final Finance finance;
    private final Invoker invoker;

    public SchoolFacade(School school) {
        this.school = school;
        this.finance = Finance.getInstance();
        this.invoker = new Invoker(); // Command invoker
    }

    /**
     * Registers a new student using the AddStudentCommand.
     *
     * @param id    the unique ID of the student.
     * @param name  the name of the student.
     * @param grade the grade of the student.
     */
    public void registerStudent(int id, String name, int grade) {
        StudentFactory studentFactory = new StudentFactory();
        Student student = studentFactory.createStudent(id, name, grade);

        AddStudentCommand addStudentCommand = new AddStudentCommand(school, student);
        invoker.executeCommand(addStudentCommand);
    }

    /**
     * Hires a new teacher using the AddTeacherCommand.
     *
     * @param id    the unique ID of the teacher.
     * @param name  the name of the teacher.
     * @param salary the salary of the teacher.
     */
    public void hireTeacher(int id, String name, int salary) {
        TeacherFactory teacherFactory = new TeacherFactory();
        Teacher teacher = teacherFactory.createTeacher(id, name, salary);
        AddTeacherCommand addTeacherCommand = new AddTeacherCommand(school, teacher);
        invoker.executeCommand(addTeacherCommand);
    }

    /**
     * Displays a summary of the school's current status.
     */
    public void displaySchoolSummary() {
        System.out.println("School Summary:");
        System.out.println("Teachers: " + school.getTeachers().size());
        System.out.println("Students: " + school.getStudents().size());
        System.out.println(finance.toString());
    }
}
