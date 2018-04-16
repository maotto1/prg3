package persons;

import interfaces.PersonInterface;

public class Human implements PersonInterface {
	
	private int age;
	private String surname, forename;
	private char sex;
	
	public Human(String surname, String forename, int age, char sex){
		this.age = age;
		this.forename = forename;
		this.surname = surname;
		this.sex = sex;
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

}
