package persons;

import interfaces.StudentInterface;
import start.Weekday;

public class Student extends Human implements StudentInterface{
	
	private final int matrikelNumber;
	private int semester;
	private String course, university, degree;
	
	public Student(int matrikelnummer, int semester, String university, String degree, String course, String surname, String forename, int age, char sex, Weekday[] freeDays){
		super(surname, forename, age, sex, freeDays);
		matrikelNumber = matrikelnummer;
		this.semester = semester;
		this.university = university;
		this.course = course;
		this.setDegree(degree);
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
}