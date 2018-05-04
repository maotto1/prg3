import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import control.IntersectionContext;
import states.UpDownDownright;
import states.UpUpleftLeftright;

public class IntersectionContextTest {
	IntersectionContext context;
;

	@Before
	public void setUp() throws Exception {
		context = new IntersectionContext();
	}

	@Test
	public void getStateTest() {
		assertEquals(new UpDownDownright().getClass(), context.getState().getClass());
	}
	
	/**
	 * check class variables
	 */
	@Test
	public void setIntersectionStateTest() {
		long lastChange1 = System.currentTimeMillis(), lastChange2;
		context.setIntersectionState(new UpUpleftLeftright());
		lastChange2 = System.currentTimeMillis();
		assertTrue(lastChange1 < lastChange2);
		assertSame(new UpUpleftLeftright().getClass(), context.getState().getClass() );
	}
	
}
