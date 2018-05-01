import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import observable.SensorEvent;
import observable.SensorPosition;

public class SensorEventTest {
	private SensorPosition position;

	@Before
	public void setUp() throws Exception {
		position = SensorPosition.DOWN; 
	}
 
	@Test
	public void getSensorPositionTest() {
		assertEquals(position, new SensorEvent(this, position).getSensorPosition());
	}
		
	
}
