package controller;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ControllerTest {

	private ControllerOrder controllerOrder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controllerOrder = ControllerOrder.NOTHING;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOrderPerform() {
		
	}
}
