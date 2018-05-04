package observable;

import java.util.ArrayList;
import java.util.List;

import observer.SensorEventListener;

public class SensorEventHandler {
	
	private final List<SensorEventListener> listenerList= new ArrayList<SensorEventListener>();
	
	public boolean add(SensorEventListener listener) {
		return this.listenerList.add(listener);
	}
	
	public boolean remove(SensorEventListener listener) {
		return this.listenerList.remove(listener);
	}
	
	public void notify(SensorEvent event) {
		for (SensorEventListener listener : listenerList)
			listener.onInputEvent(event);
	}
}
