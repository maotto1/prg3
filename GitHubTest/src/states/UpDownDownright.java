package states;

public class UpDownDownright implements IntersectionTrafficLightsState{
	
	final TrafficLight UP = TrafficLight.GREEN;
	final TrafficLight UP_LEFT = TrafficLight.RED ;
	final TrafficLight DOWN = TrafficLight.GREEN;
	final TrafficLight DOWN_RIGHT = TrafficLight.GREEN;
	final TrafficLight LEFT_RIGHT = TrafficLight.RED;
	final TrafficLight LEFT_LEFT = TrafficLight.RED;
	
	@Override
	public TrafficLight[] getTrafficLigthConfiguration() {
		return new TrafficLight[] {UP, UP_LEFT, DOWN, DOWN_RIGHT, LEFT_RIGHT, LEFT_LEFT};
	}

}
