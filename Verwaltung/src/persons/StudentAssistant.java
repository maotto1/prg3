package persons;

import java.util.ArrayList;
import java.util.Date;

import start.Weekday;

public class StudentAssistant extends Student {
	
	private Date contractBegin, contractEnd;
	private ArrayList<Weekday> freeDays;
	
	StudentAssistant(int matrikelnummer) {
		super(matrikelnummer);
	}

}
