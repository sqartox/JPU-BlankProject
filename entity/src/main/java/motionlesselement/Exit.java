package motionlesselement;

import element.Sprite;

/**
 * The Class Exit.
 *
 * @author Jean michel crapaud
 * The class Exit
 * Saved as file Exit.java
 */
public class Exit extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Door");

	/**
	 * Instantiates a new exit.
	 *
	 * @param x the x
	 * @param y the y
	 */
	// Exit constructor
	public Exit(int x, int y) {
		// Call the Motionless Element constructor to instantiate a new Motionless Element
		super(SPRITE, x, y);
	}

}
