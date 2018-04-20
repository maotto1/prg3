package start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import output.OutputImplementation;
import persons.Employee;
import persons.Human;
import persons.Student;
import persons.StudentAssistant;

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
		String surname, forename, days;
		int age, choice;
		char sex;
		Weekday[] freeDays = null;
		System.out.println("Please enter surname");
		surname = scanner.next().trim();
		System.out.println("Please enter forename");
		forename = scanner.next().trim();
		System.out.println("Please enter sex");
		sex = scanner.next().trim().charAt(0);
		System.out.println("Please enter age");
		age = scanner.nextInt();
		System.out.println("Please enter numbers for free days (example: 157 ~ Monday, Friday, Sunday )");
		days = String.valueOf(scanner.nextInt());
		if (days.length()>0)
			freeDays = new Weekday[days.length()];
		for (int i=0; i < days.length(); i++ ) {
			freeDays[i] = Weekday.getWeekday(Integer.parseInt(String.valueOf(days.charAt(i))));
		}
		
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
			insertStudentDialog(surname, forename, age, sex, freeDays);
		if (choice == 2) {
			insertStudentAssistantDialog(surname, forename, age, sex, freeDays);
		}
		if (choice == 3)
			insertEmployeeDialog(surname, forename, age, sex, freeDays);
		if (choice == 4)
			this.storage.insertPerson(new Human(surname, forename, age, sex, freeDays)); 

	}
	
	private void insertStudentDialog(String surname, String forename, int age, char sex, Weekday[] freeDays) {
		int matrikelnummer, semester;
		String university, degree, course;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter matrikelnumber");
		matrikelnummer = scanner.nextInt();
		System.out.println("Please enter semester");
		semester = scanner.nextInt();
		System.out.println("Please enter name of university");
		university = scanner.next().trim();
		System.out.println("Please enter degree");
		degree = scanner.next().trim();
		System.out.println("Please enter course name");
		course = scanner.next().trim();
		
		this.storage.insertPerson(new Student(matrikelnummer, semester, university, degree, course, surname, forename, age, sex, freeDays));
	}
	
	private void insertStudentAssistantDialog(String surname, String forename, int age, char sex, Weekday[] freeDays) {
		int matrikelnummer, semester, minHours, maxHours;
		String university, degree, course;
		Scanner scanner = new Scanner(System.in);
		double hourlyWage;
		Date contractBegin = null, contractEnd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		System.out.println("Please enter matrikelnumber");
		matrikelnummer = scanner.nextInt();
		System.out.println("Please enter semester");
		semester = scanner.nextInt();
		System.out.println("Please enter name of university");
		university = scanner.next().trim();
		System.out.println("Please enter degree");
		degree = scanner.next().trim();
		System.out.println("Please enter course name");
		course = scanner.next().trim();
		
		System.out.println("Please enter minimal number of hours at work per week");
		minHours = scanner.nextInt();
		System.out.println("Please enter maximal number of hours at work per week");
		maxHours = scanner.nextInt();
		System.out.println("Please enter hourly wage");
		hourlyWage = scanner.nextDouble();
		System.out.println("Please enter contract begin (Format: dd.mm.YYYY)");
		try {
			contractBegin = sdf.parse( scanner.next().trim()) ;
		} catch (ParseException e) {
			System.out.println("Date not accepted.");
		}
		System.out.println("Please enter contract end (Format: dd.mm.YYYY)");
		try {
			contractEnd = sdf.parse( scanner.next().trim()) ;
		} catch (ParseException e) {
			System.out.println("Date not accepted.");
		}
		
		this.storage.insertPerson(new StudentAssistant(matrikelnummer, semester, university, degree, course, maxHours, minHours, hourlyWage, contractBegin, contractEnd, surname, forename, age, sex, freeDays));
	}
	
	private void insertEmployeeDialog(String surname, String forename, int age, char sex,  Weekday[] freeDays) {
		Scanner scanner = new Scanner(System.in);
		String employer, position;
		Date contractBegin = null; 
		double salary;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		System.out.println("Please enter employer");
		employer = scanner.next().trim();
		System.out.println("Please enter position");
		position = scanner.next().trim();
		System.out.println("Please enter contract begin (Format: dd.mm.YYYY)");
		try {
			contractBegin = sdf.parse( scanner.next().trim()) ;
		} catch (ParseException e) {
			System.out.println("Date not accepted.");
		}
		System.out.println("Please enter salary");
		salary = scanner.nextDouble();
		
		this.storage.insertPerson(new Employee(employer, position, contractBegin, salary, surname, forename, age, sex, freeDays));
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
