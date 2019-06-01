package element;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {

	private Sprite sprite;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite("Down_Rockford");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetSpriteName() {
		final String expected = "Down_Rockford";
		assertEquals(expected, this.sprite.getSpriteName());
	}

	@Test
	public void testLoadSprite() {
		final Sprite expected = this.sprite;
		assertEquals(expected, this.sprite);
	}

	@Test
	public void testGetImage(){
		final BufferedImage expected = this.sprite.getImage();
		assertEquals(expected, this.sprite.getImage());
	}

}
