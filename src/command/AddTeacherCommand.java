package command;

import model.School;
import model.Teacher;

public class AddTeacherCommand implements SchoolCommand {
    private School school;
    private Teacher teacher;

    public AddTeacherCommand(School school, Teacher teacher) {
        this.school = school;
        this.teacher = teacher;
    }

    @Override
    public void execute() {
        if (teacher != null) {
            school.getTeachers().add(teacher);
            System.out.println("Teacher added: " + teacher);
        }
    }
}