package motionlesselement;

import element.Sprite;
import element.Transparency;

/**
 * @author Jean michel crapaud
 * The class EmptyPath
 * Saved as file EmptyPath.java
 */
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
