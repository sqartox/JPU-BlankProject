package controller;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ControllerTest {
	
	private ControllerOrder orderPerform;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.orderPerform = ControllerOrder.NOTHING;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOrderPerform() {
		final ControllerOrder expected = ControllerOrder.NOTHING;
		assertEquals(expected, this.orderPerform);
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
}
