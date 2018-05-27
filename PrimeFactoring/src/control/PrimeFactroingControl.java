package control;

import java.util.Scanner;

import observable.UserEventHandler;
import observer.PrimeFactorFinder;

public class PrimeFactroingControl {
	private final UserEventHandler handler;
	
	public PrimeFactoringControl{
		listener = new UserEventHandler(0);
		listener.
	}
	
	public void run() {
		Scanner scanner;
		String input;
		int number;
		boolean exitCommand = false;
		while(!exitCommand) {
			input = scanner.next().trim();
			number = Integer.parseInt(input);
			if (input.charAt(0) == 'x') {
				
			}
			else if (number > 1 && number < Integer.MAX_VALUE/2)
		}
	}
}
