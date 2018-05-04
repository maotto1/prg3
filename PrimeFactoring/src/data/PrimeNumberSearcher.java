package data;

import java.util.ArrayList;
import java.util.HashMap;

public class PrimeNumberSearcher extends Thread{
	
	public static final HashMap<Integer, Integer> primeNumbers = new HashMap<Integer, Integer>();
	public static final HashMap<Integer, ArrayList<Integer>> divisors = new HashMap<Integer, ArrayList<Integer>>();
	
	private void putPrime(int prime) {
		primeNumbers.put(prime, 1);
	}
	
	private void putDivisibleNumber(int number) {
		primeNumbers.put(number, 0);
	}
	
	public void run() {
		
	}

}
