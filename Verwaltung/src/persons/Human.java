package persons;

public abstract class Human {
	
	private int age;
	private String surname, forename;
	private char sex;
	
	public int getAge() {
		return age;
	}
	public void incrementAge(int age) {
		this.age +=1;
	}
	public String getName() {
		return surname;
	}
	public void setName(String name) {
		this.surname = surname;
	}
	
	

}
