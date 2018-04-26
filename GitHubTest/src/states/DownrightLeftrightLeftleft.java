package states;

public class DownrightLeftrightLeftleft implements IntersectionTrafficLightsState{
	
	final TrafficLight UP = TrafficLight.RED;
	final TrafficLight UP_LEFT = TrafficLight.RED ;
	final TrafficLight DOWN = TrafficLight.RED;
	final TrafficLight DOWN_RIGHT = TrafficLight.GREEN;
	final TrafficLight LEFT_RIGHT = TrafficLight.GREEN;
	final TrafficLight LEFT_LEFT = TrafficLight.GREEN;
	
	@Override
	public TrafficLight[] getTrafficLigthConfiguration() {
		return new TrafficLight[] {UP, UP_LEFT, DOWN, DOWN_RIGHT, LEFT_RIGHT, LEFT_LEFT};
	}

}
