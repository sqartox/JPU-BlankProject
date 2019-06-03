package controller;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.IView;

public class ControllerTest {
	

	private IView view;
	private IModel model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testUserOrder(){
		try {
			new Controller(view, model);
//			fail("Should throw exception when Y position < 0");
		} catch (final Exception e) {
			final String expected = "Invalid order";
			assertEquals(expected, e.getMessage());
		}
	}
}
