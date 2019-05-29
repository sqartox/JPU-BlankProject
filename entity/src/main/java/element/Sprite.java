package element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Jean michel crapaud
 * The class Sprite
 * Saved as file Sprite.java
 */
public class Sprite {

	/** The image name. */
	private String sprite_name;

	public Sprite(final String sprite_name) {
		this.setSpriteName(sprite_name);
	}

	public String getSpriteName() {
		return sprite_name;
	}

	public void setSpriteName(String sprite_name) {
		this.sprite_name = sprite_name;
	}
	
	public BufferedImage loadSprite(String sprite_name) {
		try {
			return ImageIO.read(new File("..\\entity\\src\\main\\resources\\sprite\\" + sprite_name  + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
