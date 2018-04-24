package observable;

import java.util.ArrayList;
import java.util.List;

import observer.SensorEventListener;

public class SensorEventHandler {
	
	List<SensorEventListener> listenerList= new ArrayList<SensorEventListener>();
	
	public void add(SensorEventListener listener) {
		this.listenerList.add(listener);
	}
	
	public void remove(SensorEventListener listener) {
		this.listenerList.remove(listener);
	}
	
	public void notify(SensorEvent event) {
		for (SensorEventListener listener : listenerList)
			listener.onInputEvent(event);
	}
}
