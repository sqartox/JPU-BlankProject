package motionlesselement;

import element.Sprite;
import element.Transparency;

public class EmptyPath extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("Black");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public EmptyPath(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public EmptyPath() {
		super();
	}

}
