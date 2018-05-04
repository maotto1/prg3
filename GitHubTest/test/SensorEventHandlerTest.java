
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import control.IntersectionContext;
import observable.SensorEventHandler;
import observer.SensorEventListener;

public class SensorEventHandlerTest {
	List<SensorEventListener> list;
	SensorEventHandler handler;
	SensorEventListener lis = new SensorEventListener(new IntersectionContext());
	
	
	@Before
	public void setUp() throws Exception {
		handler = new SensorEventHandler();
		list= new ArrayList<SensorEventListener>();
		list.add(new SensorEventListener(new IntersectionContext()));
		list.add(lis);
	}

	
	@Test
	public void removeTest() {
		assertFalse(handler.remove(new SensorEventListener(new IntersectionContext())) );
		assertTrue(handler.remove(lis) );
	}


}
