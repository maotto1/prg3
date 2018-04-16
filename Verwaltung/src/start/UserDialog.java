package start;

import java.util.Scanner;

import output.OutputImplementation;
import persons.Human;

public class UserDialog {
	
	private Storage storage;
	private OutputImplementation out;
	
	UserDialog(Storage storage){
		this.storage = storage;
		out = new OutputImplementation(storage);
	}

	public void start() {
		int userInput= 0;
		do {
			userInput = menu();
			if (userInput == 1)
				insertPersonDialog();
			if (userInput == 2)
				out.printInstances();
			if (userInput == 3)
				out.printInstancesSortedByType();
			if (userInput == 4)
				searchDialog();
		} while(userInput !=5);
		System.out.println("GoodBye!");
	}
	
	private void searchDialog() {
		System.out.println("Please write surname of person: ");
		Scanner scanner = new Scanner(System.in);
		String wanted = scanner.next().trim();
		System.out.println("Result(s) for "+wanted + " : \n");
		out.search(wanted);
	}

	private void insertPersonDialog() {
		Scanner scanner = new Scanner(System.in);
		String surname, forename;
		int age, choice;
		char sex;
		System.out.println("Please enter surname");
		surname = scanner.next().trim();
		System.out.println("Please enter forename");
		forename = scanner.next().trim();
		System.out.println("Please enter surname");
		sex = scanner.next().trim().charAt(0);
		System.out.println("Please enter age");
		age = scanner.nextInt();
		
		do{
			System.out.println("What kind of person want you create? Press number to\n");
			System.out.println("1 \t student");
			System.out.println("2 \t student assistant");
			System.out.println("3 \t employee");
			System.out.println("4 \t someone else");
			choice = scanner.nextInt();
			if (choice > 4 && choice <1)
				System.out.println("invalid choice");
		} while(choice > 4 && choice <1);
		
		if (choice == 1)
			insertStudentDialog(surname, forename, age, sex);
		if (choice == 2) {
			insertStudentAssistantDialog(surname, forename, age, sex);
		}
		if (choice == 3)
			insertEmployeeDialog(surname, forename, age, sex);
		if (choice == 4)
			this.storage.insertPerson(new Human(surname, forename, age, sex)); 

	}
	
	private void insertStudentDialog(String surnname, String forname, int age, char sex) {
		
	}
	
	private void insertStudentAssistantDialog(String surnname, String forname, int age, char sex) {
		
	}
	
	private void insertEmployeeDialog(String surnname, String forname, int age, char sex) {
		
	}

	private int menu() {
		int choice;
		System.out.println("Menu: press number to\n");
		System.out.println("1 \t insert new person");
		System.out.println("2 \t show all");
		System.out.println("3 \t show all sorted by type");
		System.out.println("4 \t search surname");
		System.out.println("5 \t exit\n");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		return choice;
	}

}
