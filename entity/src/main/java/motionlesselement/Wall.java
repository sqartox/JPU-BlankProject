package motionlesselement;

import element.Sprite;

/**
 * The Class Wall.
 *
 * @author Jean michel crapaud
 * The class Wall
 * Saved as file Wall.java
 */
public class Wall extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Wall");

	/**
	 * Instantiates a new wall.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Wall(int x, int y) {
		super(SPRITE, x, y);
	}
}
