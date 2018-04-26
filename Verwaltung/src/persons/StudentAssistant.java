package persons;

import java.util.Date;

import interfaces.StudentAssistantInterface;
import start.Weekday;

public class StudentAssistant extends Student implements StudentAssistantInterface {
	
	private Date contractBegin, contractEnd;
	private double hourlyWage;
	private int minHours, maxHours;
	
	public StudentAssistant(int matrikelnummer, int semester, String university, String course, String degree, 
			int minHours, int maxHours, double hourlyWage, Date contractBegin, Date contractEnd,
			String surname, String forename, int age, char sex, Weekday[] freeDays) {
		super(matrikelnummer, semester, university, course, degree, surname, forename, age, sex, freeDays);
		this.hourlyWage = hourlyWage;
		this.contractBegin = contractBegin;
		this.contractEnd = contractEnd;
		this.minHours = minHours;
		this.maxHours = maxHours;
	}

	@Override
	public Date getContractBegin() {
		return contractBegin;
	}

	@Override
	public Date getContractEnd() {
		return contractEnd;
	}

	@Override
	public double getHourlyWage() {
		return hourlyWage;
	}

	@Override
	public int getMinHours() {
		return minHours;
	}

	@Override
	public int getMaxHours() {
		return maxHours;
	}

}
