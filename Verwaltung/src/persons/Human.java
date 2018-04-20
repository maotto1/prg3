package persons;

import interfaces.PersonInterface;
import start.Weekday;

public class Human implements PersonInterface {
	
	private int age;
	private String surname, forename;
	private char sex;
	private Weekday[] freeDays;
	
	public Human(String surname, String forename, int age, char sex, Weekday[] freeDays){
		this.age = age;
		this.forename = forename;
		this.surname = surname;
		this.sex = sex;

		this.freeDays = new Weekday[freeDays.length];
		for (int i=0; i< freeDays.length; i++) {
			this.freeDays[i] = freeDays[i];
		}

	}
		
	
	public int getAge() {
		return age;
	}
	public void incrementAge() {
		this.age +=1;
	}
	public String getName() {
		return surname + ", " + forename;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public char getSex() {
		return sex;
	}


	@Override
	public Weekday[] getFreeWeekdays() {
		Weekday[] days = new Weekday[freeDays.length];
		for (int i=0; i< days.length; i++) {
			days[i] = freeDays[i];
		}
		return days;
	}

}
