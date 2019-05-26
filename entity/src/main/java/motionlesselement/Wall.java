package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class Wall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;

	public Wall(Position position) {
		super(SPRITE, TRANSPARENCY, position);
	}

	public Wall() {
		super(SPRITE, TRANSPARENCY, null);
	}
}
