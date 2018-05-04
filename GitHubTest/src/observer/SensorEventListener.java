package observer;

import java.util.EventListener;

import control.IntersectionContext;
import observable.SensorEvent;
import observable.SensorPosition;
import states.DownrightLeftrightLeftleft;
import states.UpDownDownright;
import states.UpUpleftLeftright;

public class SensorEventListener implements EventListener {
	
	private final IntersectionContext context;
	
	public SensorEventListener(IntersectionContext context) {
		this.context = context;
	}
	
	public void onInputEvent(SensorEvent event) {

		if (event.getSensorPosition() ==  SensorPosition.DOWN)
			context.setIntersectionState(new UpDownDownright());
		if (event.getSensorPosition() ==  SensorPosition.UPLEFT)
			context.setIntersectionState(new UpUpleftLeftright());
		if (event.getSensorPosition() ==  SensorPosition.LEFTLEFT)
			context.setIntersectionState(new DownrightLeftrightLeftleft());
	}

}
