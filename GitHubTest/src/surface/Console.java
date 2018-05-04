package surface;

import control.IntersectionContext;
import observerPattern.Observer;
import observerPattern.Subject;
import states.TrafficLight;

public class Console implements Observer{
	
	private final IntersectionContext context;
	
	public Console(IntersectionContext context) {
		this.context = context;
	}
	
	
	public void printStatus() {
		TrafficLight[] actualLights = context.getState().getTrafficLigthConfiguration();
		//System.out.println("");
		for (TrafficLight light: actualLights) {
			System.out.printf("\t%s", light.toString());
		}
		System.out.println("");
	}


	@Override
	public void update(Subject subject) {
		printStatus();
		
	}


	public void instruct() {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		System.out.println("Our situation:  3 directions, 6 trafficLights");
		System.out.printf("\n\t\t\t|\t|\t||\t\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		System.out.printf("\n\t\t\t|\t|\t||\t\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		System.out.printf("\n\t\t\t|\t|\t||\t\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		
		System.out.printf("\n\t_______________\t|\t|\t||\t\t|");
		System.out.printf("\n\t\t\t\t|\t||\t\t|");
		System.out.printf("\n\t\t\t\t|\t||\t\t|");
		System.out.printf("\n\t__  __  __  __\t________|\t||\t\t|");
		System.out.printf("\n\t\t\t\t\t\t\t|");
		System.out.printf("\n\t\t\t\t\t\t\t|");
		System.out.printf("\n\t________________________\t\t\t|");
		System.out.printf("\n\t\t\t\t\t\t\t|");
		System.out.printf("\n\t\t\t\t\t\t\t|");
		System.out.printf("\n\t__  __  __  __\t________\t||\t|\t|");
		System.out.printf("\n\t\t\t\t|\t||\t|\t|");
		System.out.printf("\n\t\t\t\t|\t||\t|\t|");
		System.out.printf("\n\t_______________\t\t|\t||\t|\t|");
		
		System.out.printf("\n\t\t\t|\t|\t||\t|\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		System.out.printf("\n\t\t\t|\t|\t||\t|\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		System.out.printf("\n\t\t\t|\t|\t||\t|\t|");
		System.out.printf("\n\t\t\t|\t\t||\t\t|");
		
		System.out.println("\n3 sensors at directions : UPLEFT, DOWN, LEFTLEFT");
		System.out.println("\npress number to set car to crossroad driving in direction");
		System.out.println("\n 0 for  UP");
		System.out.println("\n 1 for  UP_LEFT");
		System.out.println("\n 2 for  DOWN");
		System.out.println("\n 3 for DOWN_RIGHT");
		System.out.println("\n 4 for LEFT_RIGHT");
		System.out.println("\n 5 for LEFT_LEFT\n");
		System.out.println("\n\tUP\tUPLEFT\tDOWN\tDOWNRIGHT\tLEFTRIGHT\tLEFTLEFT\n");
	}
	
	

}
