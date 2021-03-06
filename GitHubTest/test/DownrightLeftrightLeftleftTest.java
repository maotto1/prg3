import static org.junit.Assert.*;

import org.junit.Test;

import states.DownrightLeftrightLeftleft;
import states.TrafficLight;

public class DownrightLeftrightLeftleftTest {

	@Test
	public void test() {
		assertArrayEquals(new TrafficLight[] {
				TrafficLight.RED, TrafficLight.RED, TrafficLight.RED, TrafficLight.GREEN, 
				TrafficLight.GREEN, TrafficLight.GREEN}, 
				new DownrightLeftrightLeftleft().getTrafficLigthConfiguration());
	}

}
