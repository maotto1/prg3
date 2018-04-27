import static org.junit.Assert.*;
import org.junit.Test;
import states.TrafficLight;
import states.UpUpleftLeftright;


public class UpUpleftLeftrightTest {
	
	@Test
	public void test() {
		assertArrayEquals(new TrafficLight[] {
				TrafficLight.GREEN, TrafficLight.GREEN, TrafficLight.RED, TrafficLight.RED, 
				TrafficLight.GREEN, TrafficLight.RED}, 
				new UpUpleftLeftright().getTrafficLigthConfiguration());
	}
}
