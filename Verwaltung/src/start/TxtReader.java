package start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import persons.Employee;
import persons.Human;
import persons.Student;
import persons.StudentAssistant;

public class TxtReader {

	private Storage storage;

	public TxtReader(Storage stor) {
		storage = stor;
	}

	/**
	 * method reads a file with example data and parses it to instances of humans
	 * 
	 * @param file
	 */
	public void read(String file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line, surname, forename;
			String employer, position;
			String dateString, weekdays;
			int matrikelnummer, semester; 
			String university, degree, course;
			int minHours, maxHours; 
			double hourlyWage; 
			Date contractBegin = new Date(), contractEnd = new Date();
			Weekday[] days;
			int age, commaIndex;
			double salary;
			char sex, type;
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");


			
			while ((line = reader.readLine()) != null) {

				// that what all have common
				commaIndex = line.indexOf(',');
				surname = line.substring(0, commaIndex);
				line = line.substring(commaIndex + 1, line.length()).trim();

				commaIndex = line.indexOf(',');
				forename = line.substring(0, commaIndex);
				line = line.substring(commaIndex + 1, line.length()).trim();

				commaIndex = line.indexOf(',');
				age = Integer.parseInt(line.substring(0, commaIndex));
				line = line.substring(commaIndex + 1, line.length()).trim();

				commaIndex = line.indexOf(',');
				sex = line.charAt(0);
				line = line.substring(commaIndex + 1, line.length()).trim();
				
				commaIndex = line.indexOf(',');
				weekdays = line.substring(0, commaIndex).trim();
				if (weekdays.length() >0 ) {
					days = new Weekday[ weekdays.length() ];
					for (int i=0; i<weekdays.length(); i++) {
						days[i] = Weekday.getWeekday( Integer.parseInt( String.valueOf( weekdays.charAt(i)))  );
					}
				}
				else
					days = null;
				line = line.substring(commaIndex + 1, line.length()).trim();

				// type specifying symbol 
				commaIndex = line.indexOf(',');
				type = line.charAt(0);
				line = line.substring(commaIndex + 1, line.length()).trim();
				
				switch (type) {
				case 'E':
					commaIndex = line.indexOf(',');
					employer = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					position = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					dateString = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					//cal = new GregorianCalendar(Integer.valueOf(dateString.substring(0, 3)), 
					//		Integer.valueOf(dateString.substring(5, 6)), Integer.valueOf(dateString.substring(8, 9)));
					
					try {
						date = simpleDateFormat.parse(dateString);
					} catch (ParseException e) {
						// TODO Automatisch generierter Erfassungsblock
						System.out.println("Fehler beim Einlesen des Vertragsbeginns von "+ surname);
						e.printStackTrace();
					}
					
					commaIndex = line.indexOf(',');
					salary = Double.valueOf( line.substring(0, commaIndex).trim() );
					line = line.substring(commaIndex + 1, line.length()).trim();
		
					storage.insertPerson(new Employee(employer, position, date, salary, surname, forename, age, sex, days));
					break;
				case 'A':
					commaIndex = line.indexOf(',');
					matrikelnummer = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					semester = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					university = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					degree = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					course = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					minHours = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					maxHours = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					hourlyWage = Double.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					dateString = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();					
					try {
						contractBegin = simpleDateFormat.parse(dateString);
					} catch (ParseException e) {
						System.out.println("Fehler beim Einlesen des Vertragsbeginns von "+ surname);
						e.printStackTrace();
					}
					
					commaIndex = line.indexOf(',');
					dateString = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();					
					try {
						contractEnd = simpleDateFormat.parse(dateString);
					} catch (ParseException e) {
						System.out.println("Fehler beim Einlesen des Vertragsbeginns von "+ surname);
						e.printStackTrace();
					}
					
					storage.insertPerson(new StudentAssistant(matrikelnummer, semester, university, degree, course,
							minHours, maxHours, hourlyWage, contractBegin, contractEnd, 
							surname, forename, age, sex, days));
					break; 
				case 'S':
					commaIndex = line.indexOf(',');
					matrikelnummer = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					semester = Integer.valueOf(line.substring(0, commaIndex).trim());
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					university = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					degree = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					commaIndex = line.indexOf(',');
					course = line.substring(0, commaIndex);
					line = line.substring(commaIndex + 1, line.length()).trim();
					
					
					storage.insertPerson(new Student(matrikelnummer, semester, university, degree, course, 
							surname, forename, age, sex, days));
					break;
					default:
						storage.insertPerson(new Human(surname, forename, age, sex, days));
				}

				

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
		}

	}

}
