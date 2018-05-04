package observer;

import java.util.ArrayList;

import data.PrimeNumberSearcher;
import observable.ExitEvent;
import observable.UserEvent;

public class PrimeFactorFinder extends Thread implements UserEventListener{
	int number;
	ArrayList<Integer> divisors;
	
	public PrimeFactorFinder(int number) {
		this.number = Math.abs(number);
		divisors = new ArrayList<Integer>();
	}

	@Override
	public void onInputEvent(UserEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void onInputEvent(ExitEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	private void printResult() {
		
	}
	
	private void examineNumber(int number) {
		// prüfen ob bereits ermittelt
		if (PrimeNumberSearcher.primeNumbers.get(number) == 1)
			divisors.add(number);
		else if (PrimeNumberSearcher.primeNumbers.get(number) == 0) {
			// for  alle Teiler (liste unvollstänidg?) rufe examineNumber auf
		}
			
	}
	
	public void run() {
		if (!PrimeNumberSearcher.primeNumbers.containsKey(number) ) {
			
		}
		if (PrimeNumberSearcher.primeNumbers.get(number) == 1)
			printResult();
		else if (PrimeNumberSearcher.primeNumbers.get(number) == 0)
			printResult();
	}
}
