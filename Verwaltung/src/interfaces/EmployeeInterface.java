package interfaces;

import java.util.Date;

public interface EmployeeInterface {
	
	public void setSalary(double salary);
	public double getSalary();
	public String getEmployer();
	public String getPosition();
	public Date getContractBegin();
	public Date getContractEnd();
}
