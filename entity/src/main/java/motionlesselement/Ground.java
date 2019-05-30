package motionlesselement;

import element.Sprite;

/**
 * The Class Ground.
 *
 * @author Jean michel crapaud
 * The class Ground
 * Saved as file Ground.java
 */
public class Ground extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Background");

	/**
	 * Instantiates a new ground.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Ground(int x, int y) {
		super(SPRITE, x, y);
	}
	
}
