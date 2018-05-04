package observable;

import java.util.EventObject;


public class SensorEvent extends EventObject{
	

	private static final long serialVersionUID = 297532924417611016L;
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
