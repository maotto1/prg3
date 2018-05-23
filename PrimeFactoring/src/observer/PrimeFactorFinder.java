package observer;

import java.util.ArrayList;

import data.PrimeNumberSearcher;
import observable.ExitEvent;
import observable.UserEvent;

public class PrimeFactorFinder extends Thread implements UserEventListener{
	int number;
	ArrayList<Integer> divisors;
	private final static Object monitor=new Object();
	
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
		this.interrupt();
		
	}
	
	private void printResult() {
		synchronized(monitor) {
			System.out.printf("\nNumber %d has the following divisors:\t", number);
			for (int divisor: divisors) {
				System.out.printf("%d, ", divisor);
			}
		}
	}
	
	private void examineNumber(int number) {
		System.out.println("untersucht wird: "+number);
		// prüfen, ob Zahl schon vom Primzahlensucher behandelt wurde, sonst darauf warten
		if (!PrimeNumberSearcher.primeNumbers.containsKey(number) ) {
			try {
				PrimeNumberSearcher.getCondition(number).await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// wenn prim hinzufügen, sonst alle Teiler untersuchen
		if (PrimeNumberSearcher.primeNumbers.get(number) == 1)
			divisors.add(number);
		else if (PrimeNumberSearcher.primeNumbers.get(number) == 0) {
			int product=1;
			for  (int divisor : PrimeNumberSearcher.divisors.get(number)) {
				product *= divisor;
				examineNumber(divisor);
			}	
			if (number / product > 1) {
				examineNumber((int)(number / product));
			}
		}
			
	}
	
	private boolean allDivisorsFound(int number) {
		int product=1;
		for  (int divisor : PrimeNumberSearcher.divisors.get(number)) {
			product *= divisor;
		}	
		if (number / product > 1)
			return false;
		return true;
	}
	
	public void run() {
		if (!PrimeNumberSearcher.primeNumbers.containsKey(number) ) {
			try {
				PrimeNumberSearcher.getCondition(number).await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (PrimeNumberSearcher.primeNumbers.get(number) == 1) {
			System.out.printf("\nNumber %d is prime!", number);
			//printResult();
		}
		else if (PrimeNumberSearcher.primeNumbers.get(number) == 0) {
			if (!allDivisorsFound(number)) { 
				examineNumber(number);
				// storage result:
				PrimeNumberSearcher.rwlDivisors.writeLock().lock();
				PrimeNumberSearcher.divisors.put(number, divisors);
				PrimeNumberSearcher.rwlDivisors.writeLock().unlock();
			}

		}
		printResult();	
	}
}
