package element;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mobileelement.Player;

public class ElementTest {
	
	Element element;
	Sprite sprite;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.element = new Player(0, 1, 10);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testChangePosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckForExit() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiamond() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMap() {
		fail("Not yet implemented");
	}

}
