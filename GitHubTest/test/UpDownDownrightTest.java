
import static org.junit.Assert.*;
import org.junit.Test;
import states.TrafficLight;
import states.UpDownDownright;


public class UpDownDownrightTest {
	
	@Test
	public void test() {
		assertArrayEquals(new TrafficLight[] {
				TrafficLight.GREEN, TrafficLight.RED, TrafficLight.GREEN, TrafficLight.GREEN, 
				TrafficLight.RED, TrafficLight.RED}, 
				new UpDownDownright().getTrafficLigthConfiguration());
	}
}
