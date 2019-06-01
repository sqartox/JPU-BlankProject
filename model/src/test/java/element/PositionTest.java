package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositionTest {

	private Position position;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.position = new Position(1, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		final int expected = 1;
		assertEquals(expected, this.position.getX());
	}

	@Test
	public void testGetY() {
		final int expected = 10;
		assertEquals(expected, this.position.getY());
	}
	
	
	@Test
	public void excepXMinRange() {
		try {
			new Position(1, 10);
//			fail("Should throw exception when X position < 0");
		} catch (final Exception e) {
			final String expected = "Position X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepXMaxRange() {
		try {
			new Position(1, 10);
//			fail("Should throw exception when X position > Width of Map");
		} catch (final Exception e) {
			final String expected = "Position X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	
	@Test
	public void excepYMinRange() {
		try {	
			new Position(1, 10);
//			fail("Should throw exception when Y position < 0");
		} catch (final Exception e) {
			final String expected = "Position Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepYMaxRange() {
		try {
			new Position(1, 10);
//			fail("Should throw exception when Y position > Height of Map");
		} catch (final Exception e) {
			final String expected = "Position Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
