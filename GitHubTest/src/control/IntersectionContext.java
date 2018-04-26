package control;

import states.IntersectionTrafficLightsState;
import states.TrafficLight;
import states.UpDownDownright;

public class IntersectionContext {
	
	final long MIN_STAYING_TIME = 2000, TRANSITION_TIME = 1000; 
	private IntersectionTrafficLightsState state;
	private long lastChange;
	
	public IntersectionContext() {
		setIntersectionState(new UpDownDownright());
		lastChange = System.currentTimeMillis();
	}
	
	public void setIntersectionState (final IntersectionTrafficLightsState STATE) {
		// minimal phase of green light
		while (System.currentTimeMillis() - lastChange < MIN_STAYING_TIME) {	
		}
		
		// phase of yellow
		if (! STATE.getClass().equals(state.getClass())){
			TrafficLight[] oldLights =  state.getTrafficLigthConfiguration();
			TrafficLight[] newLights =  STATE.getTrafficLigthConfiguration();
			TrafficLight[] transition = new TrafficLight[oldLights.length];
			
			for (int i=0; i<transition.length; i++) {
				if (oldLights[i] == newLights[i])
					transition[i] = oldLights[i];
				else if (oldLights[i] == TrafficLight.GREEN &&  newLights[i] == TrafficLight.RED )
					transition[i] = TrafficLight.YELLOW;
				else if (oldLights[i] == TrafficLight.RED &&  newLights[i] == TrafficLight.GREEN )
					transition[i] = TrafficLight.REDANDYELLOW;
			}
			
			state = new IntersectionTrafficLightsState() {

				@Override
				public TrafficLight[] getTrafficLigthConfiguration() {
					return transition;
				}
				
			};
			try {
				Thread.sleep(TRANSITION_TIME);
			} catch (InterruptedException e) {
				System.out.println("YELLOW doesn't work.");
				e.printStackTrace();
			}
		}

		this.state = STATE;
		lastChange = System.currentTimeMillis();
	}
	
	public IntersectionTrafficLightsState getState() {
		return state;
	}

}
