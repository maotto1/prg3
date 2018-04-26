package start;

import control.IntersectionContext;
import observable.SensorEventHandler;
import observer.SensorEventListener;

public class Main {
	
	public static void main (String args) {
		IntersectionContext context = new IntersectionContext();
		
		// Listener & EventHandler set up
		SensorEventHandler handler = new SensorEventHandler();
		SensorEventListener listener = new SensorEventListener(context);
		handler.add(listener);
		
		// Usercommunication
				
		handler.remove(listener);
		
		//
	}
	
	
}
