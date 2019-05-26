package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Exit extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Door");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public Exit(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public Exit() {
		super();
	}

}
