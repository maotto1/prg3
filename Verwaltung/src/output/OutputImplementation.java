package output;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import interfaces.Output;
import persons.Employee;
import persons.Human;
import persons.Student;
import persons.StudentAssistant;
import start.Storage;
import start.Weekday;

public class OutputImplementation implements Output {
	
	private Storage storage;
	
	public OutputImplementation(Storage storage){
		this.storage = storage;
	}
	
	/**
	 * prints all Instances on the console
	 */
	@Override
	public void printInstances() {
		ArrayList<Human> persons = storage.getListOfPersons();
		for (Human human: persons) {
			print(human);
		}
	}
	
	
	/**
	 * print students, than student assistants and therefore employees
	 */
	@Override
	public void printInstancesSortedByType() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = storage.getListOfStudents();
		for (Student student: students) {
			print(student);
		}
		ArrayList<StudentAssistant> studentAssistants = storage.getListOfStudentAssistants();
		for (StudentAssistant human: studentAssistants) {
			print(human);
		}
		ArrayList<StudentAssistant> employees = storage.getListOfStudentAssistants();
		for (StudentAssistant employee: employees) {
			print(employee);
		}
	}
	
	/**
	 * compares all surnames of in storage saved persons with given String
	 */
	@Override
	public void search(String search) {
		ArrayList<Human> results = storage.getListOfHumansWithSurname(search);
		if (results.isEmpty())
			System.out.println("no results");
		else {
			System.out.println("found ");
			for (Human human: results)
				print(human);
		}

	}
	
	/**
	 * print on console, if human is instance from one of the following classes: Student, StudentAssistant, Employee
	 * @param human
	 */
	private void print(Human human) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("\n"+human.getName());
		System.out.printf("\t%d \t %c \t ", human.getAge(), human.getSex() );
		printFreeDays(human);
		
		if (human.getClass().equals(Student.class)) {
			System.out.println("\nStudent: \t\t");
			System.out.printf("\t%d \t%d \t%s \t%s \t%s" , ((Student) human).getMatrikelNumber(), ((Student) human).getSemester(),
					((Student) human).getUniversity(),  ((Student) human).getDegree(), ((Student) human).getCourse()
					);
		}
		else if(human.getClass().equals(StudentAssistant.class)) {
			System.out.printf("\nStudent Assistant: \t\t");
			System.out.printf("\t%d \t%d \t%s \t%s \t%s\n \t\t\tis working minimim %d and maximum %d hours per week, gets %f € per hour, is working since %s until %s" , ((Student) human).getMatrikelNumber(), ((Student) human).getSemester(),
					((Student) human).getUniversity(),  ((Student) human).getDegree(), ((Student) human).getCourse(),
					((StudentAssistant) human).getMinHours(), ((StudentAssistant) human).getMaxHours(), ((StudentAssistant) human).getHourlyWage(),
					sdf.format(((StudentAssistant) human).getContractBegin()), sdf.format(((StudentAssistant) human).getContractEnd())
					);
		}
		else if(human.getClass().equals(Employee.class)) {
			System.out.printf("\nEmployee: \t\t %s \t %s\tworking since %s until %s earning %f", 
					((Employee) human).getEmployer(), ((Employee) human).getPosition(), sdf.format(((Employee) human).getContractBegin()),
					(null == ((Employee) human).getContractEnd() ) ? "unlimited" : sdf.format(((Employee) human).getContractEnd()),
					((Employee) human).getSalary()
					);
		}
		System.out.println();
	}
	
	private void printFreeDays(Human human) {
		Weekday[] days = human.getFreeWeekdays();
		System.out.printf("free Days:\t");
		if (days.length == 0)
			System.out.printf("none");
		for (int i =0 ; i < days.length; i++) {
			System.out.printf("%s, ",days[i].toString());
		}
	}
}
