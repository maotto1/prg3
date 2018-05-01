package observable;

import java.util.EventObject;

@SuppressWarnings("serial")
public class SensorEvent extends EventObject{
	
	private final SensorPosition sensorPosition;
	
	/*
	 * source : 
	 */
	public SensorEvent(Object source, SensorPosition position) {
		super(source);
		sensorPosition = position;
		// TODO Automatisch generierter Konstruktorstub
	}

	public SensorPosition getSensorPosition() {
		return sensorPosition;
	}

}
