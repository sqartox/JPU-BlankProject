package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class IndoorWall
 * Saved as file IndoorWall.java
 */
public class IndoorWall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");

	public IndoorWall(int x, int y) {
		super(SPRITE, x, y);
	}
}
