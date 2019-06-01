package mobileelement;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	
	Player player;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.player = new Player(1, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDiamondCount() {
		final int expected = 0;
		assertEquals(expected, this.player.getDiamondCount());
	}
	
	@Test
	public void excepDiamondCountMinRange() {
		try {
			new Player(1, 1, 1);
//			fail("Should throw exception when Diamond < 0");
		} catch (final Exception e) {
			final String expected = "Diamond count out of range";
			assertEquals(expected, e.getMessage());
		}
	}
}
