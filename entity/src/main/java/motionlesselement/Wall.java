package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Wall
 * Saved as file Wall.java
 */
public class Wall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");

	public Wall(int x, int y) {
		super(SPRITE, x, y);
	}
}
