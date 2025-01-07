package command;

import model.School;
import model.Student;

public class AddStudentCommand implements SchoolCommand {
    private School school;
    private Student student;

    public AddStudentCommand(School school, Student student) {
        this.school = school;
        this.student = student;
    }

    @Override
    public void execute() {
        if (student != null) {
            school.getStudents().add(student);
            System.out.println("Student added: " + student);
        }
    }
}
