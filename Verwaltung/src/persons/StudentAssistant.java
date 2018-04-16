package persons;

import java.util.ArrayList;
import java.util.Date;

import interfaces.StudentAssistantInterface;
import start.Weekday;

public class StudentAssistant extends Student implements StudentAssistantInterface {
	
	private Date contractBegin, contractEnd;
	private ArrayList<Weekday> freeDays;
	private double hourlyWage;
	
	StudentAssistant(int matrikelnummer, int semester, String university, String course, String surname, String forename, int age, char sex) {
		super(matrikelnummer, semester, university, course, surname, forename, age, sex);
	}

}
