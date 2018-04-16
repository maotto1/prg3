package start;

import java.util.ArrayList;
import java.util.Iterator;

import persons.Employee;
import persons.Human;
import persons.Student;
import persons.StudentAssistant;

public class Storage {

	private ArrayList<Human> persons;
	
	public Storage() {
		persons = new ArrayList<Human>();
	}
	
	/**
	 * 
	 * @return deep copy of persons
	 */
	public ArrayList<Human> getListOfPersons() {
		ArrayList<Human> guys = new ArrayList<Human>();
		for (Human human: persons) {
			guys.add(human);
		}
		return guys;
	}
	
	
	
	public ArrayList<Student> getListOfStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		for (Human person : persons) {
			if (person.getClass().equals(Student.class)){
				students.add((Student) person);
			}
		}
		return students;
	}
	
	public ArrayList<StudentAssistant> getListOfStudentAssistants(){
		ArrayList<StudentAssistant> studentAssistants = new ArrayList<StudentAssistant>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for (Human person : persons) {
			if (person.getClass().equals(StudentAssistant.class)){
				studentAssistants.add((StudentAssistant) person);
			}
		}
		return studentAssistants;
	}
	
	public ArrayList<Employee> getListOfEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for (Human person : persons) {
			if (person.getClass().equals(Employee.class)){
				employees.add((Employee) person);
			}
		}
		return employees;
	}
}
