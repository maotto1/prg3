package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrimeNumberSearcher extends Thread{
	
	public static final HashMap<Integer, Integer> primeNumbers = new HashMap<Integer, Integer>();
	public static final HashMap<Integer, ArrayList<Integer>> divisors = new HashMap<Integer, ArrayList<Integer>>();
	
	Condition condition = new ReentrantLock().newCondition();
	
	
	protected boolean putPrime(int prime) {
		if (!primeNumbers.containsKey(prime)) {
			primeNumbers.put(prime, 1);
			ArrayList<Integer> entry = new ArrayList<Integer>();
			entry.add(prime);
			divisors.put (prime, entry );
			return true;
		}
		return false;
	}
	
	protected boolean putDivisibleNumber(int number) {
		if (!primeNumbers.containsKey(number)) {
			primeNumbers.put(number, 0);
			divisors.put(number, new ArrayList<Integer>());
			return true;
		}
		return false;
	}
	
	public void run() {
		for (int i=2; i<Integer.MAX_VALUE; i++) {
			if (!primeNumbers.containsKey(i)) {
				// wie stelle ich sicher, dass die Vielfachenmarkierer schon weiter sind als der Hauptthread?
			}
			// neu gestarteten Threads Zeit geben, dafür pausieren
		}
	}

}
