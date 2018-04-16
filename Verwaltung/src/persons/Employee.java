package persons;

import java.util.ArrayList;
import java.util.Date;
import start.Weekday;

public class Employee extends Human {
	
	private String employer, position;
	private Date contractBegin, contractEnd;
	private ArrayList<Weekday> freeDays;
	
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
		return freeDays;
	}
	public void setFreeDays(ArrayList<Weekday> freeDays) {
		this.freeDays = freeDays;
	}
	
	
}
