package persons;

import java.util.ArrayList;
import java.util.Date;

import interfaces.EmployeeInterface;
import start.Weekday;

public class Employee extends Human implements EmployeeInterface {
	
	private String employer, position;
	private Date contractBegin, contractEnd;
	private Weekday[] freeDays;
	
	public Employee(String employer, String position, Date contractBegin, Weekday[] freeDays, String surname, String forename, int age, char sex) {
		super(surname, forename, age, sex);
		this.employer = employer;
		this.position = position;
		this.contractBegin = contractBegin;
		this.freeDays = new Weekday[7];
		if (freeDays != null) {
			for (int i=0; i< freeDays.length; i++) {
				if (freeDays[i] == Weekday.MONDAY )
					this.freeDays[Weekday.MONDAY.ordinal()] = Weekday.MONDAY;
				if (freeDays[i] == Weekday.TUESDAY )
					this.freeDays[Weekday.TUESDAY.ordinal()] = Weekday.TUESDAY;
				if (freeDays[i] == Weekday.WEDNESDAY )
					this.freeDays[Weekday.WEDNESDAY.ordinal()] = Weekday.WEDNESDAY;
				if (freeDays[i] == Weekday.THURSDAY )
					this.freeDays[Weekday.THURSDAY.ordinal()] = Weekday.THURSDAY;
				if (freeDays[i] == Weekday.FRIDAY )
					this.freeDays[Weekday.FRIDAY.ordinal()] = Weekday.FRIDAY;
				if (freeDays[i] == Weekday.SATURDAY )
					this.freeDays[Weekday.SATURDAY.ordinal()] = Weekday.SATURDAY;
				if (freeDays[i] == Weekday.SUNDAY )
					this.freeDays[Weekday.SUNDAY.ordinal()] = Weekday.SUNDAY;
			}
		}
		else {
			this.freeDays = Weekday.values();
		}
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
	public void setFreeDays(ArrayList<Weekday> freeDays) {
		this.freeDays = null;
	}
	@Override
	public void setSurname(String name) {
		// TODO Automatisch generierter Methodenstub
		
	}
	
	
}
