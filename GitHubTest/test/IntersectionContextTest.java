import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import control.IntersectionContext;
import states.IntersectionTrafficLightsState;
import states.UpDownDownright;

public class IntersectionContextTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getStateTest() {
		assertEquals(new UpDownDownright(), new IntersectionContext().getState());
	}

}
