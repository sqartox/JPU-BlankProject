package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;

public class ViewFrameTest {

	private static final double DELTA = 1e-3;
	
	private ViewFrame viewFrame;
	private IModel model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.viewFrame = new ViewFrame(model);
		this.viewFrame.setCount(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCount() {
		final double expected = 1;
		assertEquals(expected, this.viewFrame.getCount(), DELTA);
	}

	@Test
	public void testGetTotalCount() {
		fail("Not yet implemented");
	}

}
