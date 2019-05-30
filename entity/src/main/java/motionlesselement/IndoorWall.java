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
	// Indoor Wall constructor
	public IndoorWall(int x, int y) {
		// Call the Motionless Element constructor to instantiate a new Motionless Element
		super(SPRITE, x, y);
	}
}
