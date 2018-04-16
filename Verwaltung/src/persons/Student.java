package persons;

import interfaces.StudentInterface;

public class Student extends Human implements StudentInterface{
	
	private final int matrikelNumber;
	private int semester;
	private String course, university;
	
	Student(int matrikelnummer, int semester, String university, String course, String surname, String forename, int age, char sex){
		super(surname, forename, age, sex);
		matrikelNumber = matrikelnummer;
		this.semester = semester;
		this.university = university;
		this.course = course;
	}

	@Override
	public int getMatrikelNumber() {
		return matrikelNumber;
	}

	@Override
	public int getSemester() {
		return semester;
	}

	@Override
	public String getUniversity() {
		return university;
	}

	@Override
	public String getCourse() {
		return course;
	}

	public void incrementSemester() {
		++semester;
	}
}