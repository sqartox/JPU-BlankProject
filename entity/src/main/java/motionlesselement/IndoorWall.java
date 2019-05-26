package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class IndoorWall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;

	public IndoorWall(Position position) {
		super(SPRITE, TRANSPARENCY, position);
	}

	public IndoorWall() {
		super(SPRITE, TRANSPARENCY, null);
	}
}
