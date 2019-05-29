package motionlesselement;

import element.Sprite;
import element.Transparency;

/**
 * @author Jean michel crapaud
 * The class Wall
 * Saved as file Wall.java
 */
public class Wall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;

	public Wall(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public Wall() {
		super();
	}
}
