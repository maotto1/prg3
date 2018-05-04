package control;

import java.util.Scanner;

import observable.SensorEvent;
import observable.SensorEventHandler;
import observer.SensorEventListener;
import observable.SensorPosition;
import surface.Console;

public class CrossroadControl {
	
	final private IntersectionContext context;
	final private Console console;
	final private SensorEventHandler handler;
	final private SensorEventListener listener;
	
	public CrossroadControl() {
		context = new IntersectionContext();
		
		// Observer & Subject set up
		console = new Console(context);
		context.addObserver(console);
		
		// Listener & EventHandler set up
		handler = new SensorEventHandler();
		listener = new SensorEventListener(context);
		handler.add(listener);	
	}
	
	public void initialise() {
		console.instruct();	
	}
	
	
	public void run() {
		System.out.println("");
		console.printStatus();
		Scanner scanner = new Scanner(System.in);
		String input;
		int direction;
		while ( !(input = scanner.next().trim()).equals(":q") ) {
			direction = -1;
			try {
				direction = Integer.parseInt(input);
			} catch( NumberFormatException e) {
				System.out.print(input+ " is not an integer between 0 and 5!\n");
			};
			switch (direction){
			case -1:
				break;
			case 0:
				handler.notify(new SensorEvent(this, SensorPosition.DOWN));
				break;
			case 1:
				handler.notify(new SensorEvent(this, SensorPosition.UPLEFT)); //UL
				break;
			case 2: 
				handler.notify(new SensorEvent(this, SensorPosition.DOWN)); //D
				break;
			case 3: 
				handler.notify(new SensorEvent(this, SensorPosition.DOWN));
				break;
			case 4: 
				handler.notify(new SensorEvent(this, SensorPosition.LEFTLEFT));
				break;
			case 5: 
				handler.notify(new SensorEvent(this, SensorPosition.LEFTLEFT)); //LL
				break;
			default:
				System.out.println("Invalid integer: \t" +direction);
			}
		} 
		scanner.close();
	}

	public void finish() {
		handler.remove(listener);
		context.deleteObserver(console);
		System.out.println("GoodBye!");
	}

}
