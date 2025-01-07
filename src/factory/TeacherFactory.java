package factory;

import model.Teacher;

public class TeacherFactory {
	public Teacher createTeacher(int id, String name, int salary) {
		return new Teacher(id, name, salary);
	}
}
