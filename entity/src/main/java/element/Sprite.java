package element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Sprite.
 *
 * @author Jean michel crapaud
 * The class Sprite
 * Saved as file Sprite.java
 */
public class Sprite {

	/** The image name. */
	private String sprite_name;
	
	/** The img. */
	private BufferedImage img;

	/**
	 * Instantiates a new sprite.
	 *
	 * @param sprite_name the sprite name
	 */
	// Sprite constructor
	public Sprite(final String sprite_name) {
		// Set the Sprite name
		this.setSpriteName(sprite_name);
		// Set the Sprite image
		this.img = this.loadSprite(this.sprite_name);
	}

	/**
	 * Sets the sprite name.
	 *
	 * @return sprite_name Sprite name
	 * @throws Exception exception
	 */
	// Set the Sprite name
	public String getSpriteName() throws Exception{
		return this.sprite_name;
	}
	
	public void setSpriteName(String sprite_name) {
		this.sprite_name = sprite_name;
	}
	
	/**
	 * Load sprite.
	 *
	 * @param sprite_name the sprite name
	 * @return the buffered image
	 */
	// Load the Sprite File
	public BufferedImage loadSprite(String sprite_name) {
		try {
			return ImageIO.read(new File("..\\entity\\src\\main\\resources\\sprite\\" + sprite_name  + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	// Set the Sprite image
	public BufferedImage getImage() {
		return this.img;
	}
}
