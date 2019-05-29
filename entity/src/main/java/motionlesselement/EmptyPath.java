package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class EmptyPath
 * Saved as file EmptyPath.java
 */
public class EmptyPath extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite("Black");

	public EmptyPath(int x, int y) {
		super(SPRITE, x, y);
	}

	public EmptyPath() {
		super();
	}

}
