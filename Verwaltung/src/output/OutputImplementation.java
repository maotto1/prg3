package output;

import java.util.ArrayList;

import interfaces.Output;
import persons.Employee;
import persons.Human;
import persons.Student;
import persons.StudentAssistant;
import start.Storage;

public class OutputImplementation implements Output {
	
	private Storage storage;
	
	OutputImplementation(Storage storage){
		this.storage = storage;
	}

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

	@Override
	public void search(String search) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * print on console, if human is istance from one of the following classes: Student, StudentAssistant, Employee
	 * @param human
	 */
	private void print(Human human) {
		System.out.println(human.getName());
		if (human.getClass().equals(Student.class)) {
			System.out.println("\tStudent: \t\t");
			System.out.printf("\t %s" , ((Student) human).getUniversity());
		}
		else if(human.getClass().equals(StudentAssistant.class)) {
			
		}
		else if(human.getClass().equals(Employee.class)) {
			
		}
		else {
			System.out.println("\n unkwown type of person.");
		}
	}


}
