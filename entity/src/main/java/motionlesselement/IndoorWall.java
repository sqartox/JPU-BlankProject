package motionlesselement;

import element.Sprite;
import element.Transparency;

public class IndoorWall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("indoor");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;

	public IndoorWall(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public IndoorWall() {
		super();
	}
}
