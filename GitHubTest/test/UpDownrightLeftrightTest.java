import static org.junit.Assert.*;

import org.junit.Test;

import states.TrafficLight;
import states.UpDownrightLeftright;

public class UpDownrightLeftrightTest {

	@Test
	public void test() {
		assertArrayEquals(new TrafficLight[] {
				TrafficLight.GREEN, TrafficLight.RED, TrafficLight.RED, TrafficLight.GREEN, 
				TrafficLight.GREEN, TrafficLight.RED}, 
				new UpDownrightLeftright().getTrafficLigthConfiguration());
	}

}
