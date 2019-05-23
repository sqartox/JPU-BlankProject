package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Elements extends Entity{
	private static String SPRITE_FOLDER_PATH = "../";
	
	private String sprite_name;
	private boolean moving;
	private boolean animate;
	private boolean explosive;
	private boolean falling;
	private boolean destructible;
	
	
	
	public Elements(String sprite_name, boolean moving, boolean animate, boolean explosive, boolean falling, boolean destructible){
		this.sprite_name = sprite_name;
		this.moving = moving;
		this.animate = animate;
		this.explosive = explosive;
		this.falling = falling;
		this.destructible = destructible;
	}
	
	
	//Get Sprite path
	public static String getSpriteFolderPath() {
		return SPRITE_FOLDER_PATH;
	}
	
	public String getSpritePath() {
		return getSpriteFolderPath() + getSpriteName() + ".png";
	}
	
	//Get Sprite name
	public String getSpriteName() {
		return sprite_name;
	}
	
	public void setSpriteName(String sprite_name) {
		this.sprite_name = sprite_name;
	}

	//Get if Element is moved
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
		
	//Get if Element is animated
	public boolean isAnimate() {
		return animate;
	}

	public void setAnimate(boolean animate) {
		this.animate = animate;
	}

	//Get if Element is explosive
	public boolean isExplosive() {
		return explosive;
	}

	public void setExplosive(boolean explosive) {
		this.explosive = explosive;
	}

	//Get if Element is falling
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	//Get if Element is destructible
	public boolean isDestructible() {
		return destructible;
	}

	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
	}
	
	
	//Load Sprite
	public BufferedImage loadSprite(String sprite_name) {
		BufferedImage sprite = null;
		
		try {
			sprite = ImageIO.read(new File(getSpritePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sprite;
	}
}
