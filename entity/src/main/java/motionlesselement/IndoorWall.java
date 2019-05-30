package motionlesselement;

import element.Sprite;

/**
 * The Class IndoorWall.
 *
 * @author Jean michel crapaud
 * The class IndoorWall
 * Saved as file IndoorWall.java
 */
public class IndoorWall extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Wall");

	/**
	 * Instantiates a new indoor wall.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public IndoorWall(int x, int y) {
		super(SPRITE, x, y);
	}
}
