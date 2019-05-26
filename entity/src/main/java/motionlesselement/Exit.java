package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class Exit extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Exit");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public Exit(Position position) {
		super(SPRITE, Transparency.TRANSPARENT, position);
	}

	public Exit() {
		super(SPRITE, TRANSPARENCY, null);
	}

}
