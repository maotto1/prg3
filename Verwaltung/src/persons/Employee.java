package persons;

import java.util.ArrayList;
import java.util.Date;

import interfaces.EmployeeInterface;
import start.Weekday;

public class Employee extends Human implements EmployeeInterface {
	
	private String employer, position;
	private Date contractBegin, contractEnd;
	private double salary;
	
	public Employee(String employer, String position, Date contractBegin, double salary, String surname, String forename, int age, char sex, Weekday[] freeDays) {
		super(surname, forename, age, sex, freeDays);
		this.employer = employer;
		this.position = position;
		this.contractBegin = contractBegin;
		this.contractEnd = null;
		this.salary = salary;

	}
	
	/**
	 * 
	 * @return null, if 
	 */
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getContractBegin() {
		return contractBegin;
	}
	public void setContractBegin(Date contractBegin) {
		this.contractBegin = contractBegin;
	}
	public Date getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(Date contractEnd) {
		this.contractEnd = contractEnd;
	}
	public ArrayList<Weekday> getFreeDays() {
		ArrayList<Weekday> freeDays = new ArrayList<Weekday>();
		//**
		return freeDays;
	}

	@Override
	public void setSurname(String name) {
		// TODO Automatisch generierter Methodenstub
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
