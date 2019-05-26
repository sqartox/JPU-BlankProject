package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class Ground extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Background");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public Ground(Position position) {
		super(SPRITE, TRANSPARENCY, position);
	}

	public Ground() {
		super(SPRITE, TRANSPARENCY, null);
	}
	
}
