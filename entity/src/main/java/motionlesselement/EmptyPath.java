package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class EmptyPath extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("Black");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public EmptyPath(Position position) {
		super(SPRITE, Transparency.TRANSPARENT, position);
	}

	public EmptyPath() {
		super(SPRITE, TRANSPARENCY, null);
	}

}
