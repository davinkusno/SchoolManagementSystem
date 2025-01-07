package factory;

import model.Student;

public class StudentFactory {
	public Student createStudent(int id, String name, int grade) {
		return new Student(id, name, grade);
	}
}
