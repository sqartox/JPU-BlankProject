package mobileelement;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.Direction;


public class MobileElementTest {
	
	private Player player;
	
	private int direction;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		this.player = new Player(1, 10, 10);
		this.direction = 1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChooseDirection() throws Exception {
		final Direction expected = Direction.UP;
		assertEquals(expected, this.player.chooseDirection(direction));
	}
	
	@Test
	public void excepDirectionIdOutRange() {
		try {
			new Stone(2, 10);
//			fail("Should throw exception when direction id < 1");
		} catch (final Exception e) {
			final String expected = "Expected Direction id out of range";
			assertEquals(expected, e.getMessage());
		}
	}
}
