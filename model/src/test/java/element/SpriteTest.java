package element;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	public void testGetImage() throws IOException{
		final BufferedImage expected_sprite_image = ImageIO.read(new File("..\\entity\\src\\main\\resources\\sprite\\Down_Rockford.png"));
		assertEquals(expected_sprite_image, this.sprite.getImage());
	}
}
