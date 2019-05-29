package motionlesselement;

import element.Sprite;
import element.Transparency;

/**
 * @author Jean michel crapaud
 * The class IndoorWall
 * Saved as file IndoorWall.java
 */
public class IndoorWall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;

	public IndoorWall(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public IndoorWall() {
		super();
	}
}
