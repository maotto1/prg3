package start;

public enum Weekday {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	public static Weekday getWeekday(int ordinal) {
		switch (ordinal){
		case 1 : return MONDAY;
		case 2 : return TUESDAY;
		case 3 : return WEDNESDAY;
		case 4 : return THURSDAY;
		case 5 : return FRIDAY;
		case 6 : return SATURDAY;
		case 7 : return SUNDAY;
		}
		return null;
	}
}
