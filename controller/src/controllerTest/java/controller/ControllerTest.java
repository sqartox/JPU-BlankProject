package controller;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ControllerTest {
	
	private ControllerOrder userOrder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.setUserOrder(ControllerOrder.NOTHING);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOrderPerform() {
		final ControllerOrder expected = ControllerOrder.NOTHING;
		assertEquals(expected, this.getUserOrder());
	}
	
	@Test
	public void testUserOrder() {
		try {
//			fail("Should throw exception when Y position < 0");
		} catch (final Exception e) {
			final String expected = "Invalid order.";
			assertEquals(expected, e.getMessage());
		}
	}

	public ControllerOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(ControllerOrder userOrder) {
		this.userOrder = userOrder;
	}
}
