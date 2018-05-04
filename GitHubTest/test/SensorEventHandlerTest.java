
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import control.IntersectionContext;
import observable.SensorEventHandler;
import observer.SensorEventListener;

public class SensorEventHandlerTest {
	SensorEventHandler handler;
	SensorEventListener lis;
	
	
	@Before
	public void setUp() throws Exception {
		handler = new SensorEventHandler();
		lis = new SensorEventListener(new IntersectionContext());
		handler.add(new SensorEventListener(new IntersectionContext()));
		handler.add(lis);
	}

	
	@Test
	public void removeTest() {
		assertFalse(handler.remove(new SensorEventListener(new IntersectionContext())) );
		assertTrue(handler.remove(lis) );
	}


}
