package observerPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	List<Observer> observerList= new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		observerList.add(o);
	}
	
	public void deleteObserver(Observer o) {
		observerList.remove(0);
	}
	
	public void notifyObservers() {
		for (Observer observer : observerList)
			observer.update(this);
	}
}
