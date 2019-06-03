package mobileelement;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileElementTest {
	
	private int direction;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		this.direction = 1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChooseDirection() throws Exception {
		final int expected = 1;
		assertEquals(expected, direction);
	}
	
	@Test
	public void excepDirectionIdOutRange() {
		try {
			new Stone(2, 10);
//			fail("Should throw exception when direction id < 1");
		} catch (final Exception e) {
			final String expected = "Expected Direction id out of range.";
			assertEquals(expected, e.getMessage());
		}
	}
}
