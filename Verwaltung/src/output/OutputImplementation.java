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
		
	}
	
	

	@Override
	public void printInstancesSortedByType() {
		// TODO Auto-generated method stub
		ArrayList<Human> persons = storage.getListOfPersons();
	}

	@Override
	public void search(String search) {
		// TODO Auto-generated method stub
		
	}
	
	private void print(Human human) {
		if (human.getClass().equals(Student.class)) {
			System.out.println();
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
