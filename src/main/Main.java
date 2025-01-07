package main;

import command.AddStudentCommand;
import command.Invoker;
import decorator.Scholarship;
import decorator.SportsClubMembership;
import facade.SchoolFacade;
import factory.StudentFactory;
import factory.TeacherFactory;
import iterator.Iterator;
import iterator.StudentCollection;
import iterator.TeacherCollection;
import model.School;
import model.Student;
import model.Teacher;
import observer.FinanceObserver;
import proxy.FinanceAccess;
import proxy.ProxyFinanceAccess;
import singleton.Finance;
import strategy.FeeCalculationStrategy;
import strategy.RegularFeeStrategy;
import strategy.ScholarshipFeeStrategy;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author USER
 *
 */
public class Main {
	public Main() {
		/**
		 * Factory Pattern
		 */
		System.out.println("\n=== Factory Pattern ===");
		StudentFactory studentFactory = new StudentFactory();
		TeacherFactory teacherFactory = new TeacherFactory();

		Teacher Lizzy = teacherFactory.createTeacher(1, "Lizzy", 500);
		Teacher Nelly = teacherFactory.createTeacher(2, "Nelly", 700);
		Teacher Tom = teacherFactory.createTeacher(3, "Tom", 600);

		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(Lizzy);
		teacherList.add(Nelly);
		teacherList.add(Tom);

		Student Tamara = studentFactory.createStudent(1, "Tamara", 4);
		Student Mary = studentFactory.createStudent(3, "Mary", 5);
		Student Hawkins = studentFactory.createStudent(2, "Hawkins", 12);

		List<Student> studentList = new ArrayList<>();
		studentList.add(Tamara);
		studentList.add(Mary);
		studentList.add(Hawkins);

		School mhs = new School(teacherList, studentList);
		System.out.println("School created with students and teachers using Factory Pattern.");

		Tamara.payFees(5000);
		Mary.payFees(6000);
		System.out.println("MHS has earned $" + mhs.getTotalMoneyEarned());

		/**
		 * Facade Pattern
		 */
		System.out.println("\n=== Facade Pattern ===");
		SchoolFacade schoolFacade = new SchoolFacade(mhs);
		schoolFacade.registerStudent(6, "Chris", 9);
		System.out.println("Students after Facade registration: " + mhs.getStudents() + "\n");
		schoolFacade.displaySchoolSummary();

		System.out.println("\n------Making SCHOOL PAY SALARY-----");
		Lizzy.receiveSalary(Lizzy.getSalary());
		System.out.println("MHS has spent money for salary to " + Lizzy.getName()
				+ " and now has $" + mhs.getTotalMoneyEarned());

		Nelly.receiveSalary(Nelly.getSalary());
		System.out.println("MHS has spent money for salary to " + Nelly.getName()
				+ " and now has $" + mhs.getTotalMoneyEarned());

		System.out.println(Tamara);
		System.out.println(Nelly);

		/**
		 * Singleton Pattern
		 */
		System.out.println("\n=== Singleton Pattern ===");
		Finance finance = Finance.getInstance();
		finance.addMoneyEarned(20000);
		finance.addMoneySpent(5000);
		System.out.println("Finance Singleton Instance: " + finance);

		/**
		 * Observer Pattern
		 */
		System.out.println("\n=== Observer Pattern ===");
		FinanceObserver financeObserver = new FinanceObserver(finance);
		finance.attach(financeObserver);

		finance.addMoneyEarned(10000);
		finance.addMoneySpent(2000);
		System.out.println("Observers updated after finance changes.");

		/**
		 * Command Pattern
		 */
		System.out.println("\n=== Command Pattern ===");
		Invoker invoker = new Invoker();
		Student newStudent = studentFactory.createStudent(4, "Alex", 8);
		AddStudentCommand addStudentCommand = new AddStudentCommand(mhs, newStudent);
		invoker.executeCommand(addStudentCommand);
		System.out.println("Command executed: New student added. Students in school: " + mhs.getStudents());

		/**
		 * Iterator Pattern
		 */
		System.out.println("\n=== Iterator Pattern ===");
		TeacherCollection teacherCollection = new TeacherCollection(teacherList);
		Iterator<Teacher> teacherIterator = teacherCollection.createIterator();

		System.out.println("\nIterating Teachers:");
		while (teacherIterator.hasNext()) {
			System.out.println(teacherIterator.next());
		}

		StudentCollection studentCollection = new StudentCollection(studentList);
		Iterator<Student> studentIterator = studentCollection.createIterator();

		System.out.println("\nIterating Students:");
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}

		/**
		 * Decorator Pattern
		 */
		System.out.println("\n=== Decorator Pattern ===");
		Student baseStudent = studentFactory.createStudent(1, "Alice", 10);

		// Decorate with Sports Club Membership
		Student sportsStudent = new SportsClubMembership(baseStudent);

		// Decorate with Scholarship
		Student scholarshipStudent = new Scholarship(baseStudent, 5000);

		// Combine Sports Club Membership and Scholarship
		Student enhancedStudent = new SportsClubMembership(new Scholarship(baseStudent, 5000));

		// Output details
		System.out.println("Base Student: " + baseStudent.toString() + " | Fees: $" + baseStudent.getFeesTotal());
		System.out.println("Sports Club Membership: " + sportsStudent.getDescription() + " | Fees: $" + sportsStudent.getFeesTotal());
		System.out.println("Scholarship: " + scholarshipStudent.getDescription() + " | Fees: $" + scholarshipStudent.getFeesTotal());
		System.out.println("Enhanced (Sports + Scholarship): " + enhancedStudent.getDescription() + " | Fees: $" + enhancedStudent.getFeesTotal());

		/**
		 * Proxy Pattern
		 */
		System.out.println("\n=== Proxy Pattern ===");
		FinanceAccess adminAccess = new ProxyFinanceAccess("ADMIN");
		adminAccess.addEarnings(10000);
		adminAccess.addExpenditure(2000);
		System.out.println("Admin Access Financial Summary: " + adminAccess.getFinancialSummary());

		FinanceAccess guestAccess = new ProxyFinanceAccess("GUEST");
		guestAccess.addEarnings(5000); // Should be denied
		guestAccess.addExpenditure(1000); // Should be denied
		System.out.println("Guest Access Financial Summary: " + guestAccess.getFinancialSummary());

		/**
		 * Strategy Pattern
		 */
		System.out.println("\n=== Strategy Pattern ===");
		FeeCalculationStrategy regularStrategy = new RegularFeeStrategy();
		FeeCalculationStrategy scholarshipStrategy = new ScholarshipFeeStrategy(5000);

		System.out.println("Regular Fee Calculation: $" + regularStrategy.calculateFee(baseStudent));
		System.out.println("Scholarship Fee Calculation: $" + scholarshipStrategy.calculateFee(baseStudent));
	}

	public static void main(String[] args) {
		new Main();
	}

}
