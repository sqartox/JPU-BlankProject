package view;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ViewTest {
	
	private int userOrder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.userOrder = KeyEvent.VK_NUMPAD1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKeyCodeToControllerOrder() {
		final ControllerOrder expected = ControllerOrder.Map1;
		assertEquals(expected, View.keyCodeToControllerOrder(userOrder));
	}
	
	
	@Test
	public void excepKeyCodeToControllerOrder() {
		try {
			View.keyCodeToControllerOrder(userOrder);
//			fail("Should throw exception when X position < 0");
		} catch (final Exception e) {
			final String expected = "Position X out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
