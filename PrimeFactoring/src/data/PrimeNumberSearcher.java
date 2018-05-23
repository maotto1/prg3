package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PrimeNumberSearcher extends Thread{
	
	public static final HashMap<Integer, Integer> primeNumbers = new HashMap<Integer, Integer>();
	public static final HashMap<Integer, ArrayList<Integer>> divisors = new HashMap<Integer, ArrayList<Integer>>();
	
	public static final ReentrantReadWriteLock rwlPrimeNumbers = new ReentrantReadWriteLock();
	public static final ReentrantReadWriteLock rwlDivisors = new ReentrantReadWriteLock();
	
	Condition threscondition = new ReentrantLock().newCondition();
	public static HashMap<Integer, Condition> waitingConditions = new HashMap<Integer, Condition>();
	protected final int threshold = 1000;// Integer.MAX_VALUE/2;
	
	
	protected synchronized boolean putPrime(int prime) {
		if (!primeNumbers.containsKey(prime)) {
			
			rwlPrimeNumbers.writeLock().lock();
			primeNumbers.put(prime, 1);
			rwlPrimeNumbers.writeLock().unlock();
			
			ArrayList<Integer> entry = new ArrayList<Integer>();
			entry.add(prime);
			rwlDivisors.writeLock().lock();
			divisors.put (prime, entry );
			rwlDivisors.writeLock().unlock();
			
			// eventuell wartende PrimeFactorFinder informieren
			if (waitingConditions.containsKey(prime)) {
				waitingConditions.get(prime).signalAll();
			}
			return true;
		}
		return false;
	}
	
	protected synchronized boolean putDivisibleNumber(int number) {
		if (!primeNumbers.containsKey(number)) {
			
			rwlPrimeNumbers.writeLock().lock();
			primeNumbers.put(number, 0);
			rwlPrimeNumbers.writeLock().unlock();
			
			rwlDivisors.writeLock().lock();
			divisors.put(number, new ArrayList<Integer>());
			rwlDivisors.writeLock().unlock();
			return true;
		}
		return false;
	}
	
	public synchronized boolean addDivisor(int divisor, int number) {
		int product= divisor;
		ArrayList<Integer> d = divisors.get(number);
		for  (int div : d) {
			product *= div;
		}	
		if (product > number || (number % product) != 0 )
			return false;
		else
			d.add(divisor);
		return true;
	}
	
	private static void setCondition(int prime) {
		if (!waitingConditions.containsKey(prime)) {
			waitingConditions.put(prime, new ReentrantLock().newCondition());
		}
	}
	
	public static Condition getCondition(int prime) {
		Condition c = null;
		if (!waitingConditions.containsKey(prime)) {
			setCondition(prime);
		}
		else 
			c = waitingConditions.get(prime);
		return c;
	}
	
	
	/**
	 * an implementation of the "sieb des Erathostenes"
	 */
	public void run() {
		int root = (int) Math.floor(Math.pow(threshold, 0.5));
		/* 		
		int lastThreshold = 2;
		threshold = 1000;
		int i = 2;
		 * do {
		
			if (i == threshold-1) {
				lastThreshold = threshold;
				threshold = (int) Math.pow(threshold, 2); 
				notifyAll();
			}
			for (i=lastThreshold; i<threshold; i++) {
				if (!primeNumbers.containsKey(i)) {
					// wie stelle ich sicher, dass die Vielfachenmarkierer schon weiter sind als der Hauptthread?
				}
				// neu gestarteten Threads Zeit geben, dafür pausieren
			}
		} while (i <= threshold);
		 */
		for (int i=2; i<threshold; i++) {
			//
			if (!primeNumbers.containsKey(i)) {
				putPrime(i);
				if (i <= root) { 	// teiler t größer als Wurzel der Schwelle => t^2 
					PrimeMultipleStriker striker = new PrimeMultipleStriker(i);
					striker.run();
				}

				// wie stelle ich sicher, dass die Vielfachenmarkierer schon weiter sind als der Hauptthread?
			}
		}
	}

}
