package element;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ElementTest {
	
	private Map map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		this.map = new Map(0, "pe");
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testCheckForExit() {
		final boolean expected = true;
		assertEquals(expected,this.map.getMapObjects(0, 0).checkForExit(1, 0));
	}
}
