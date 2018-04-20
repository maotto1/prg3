package interfaces;

import start.Weekday;

public interface PersonInterface {
	public int getAge();
	public void incrementAge();
	public String getName();
	public void setSurname(String name);
	public void setForename(String name);
	public char getSex();
	public Weekday[] getFreeWeekdays();
	
}
