package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Ground
 * Saved as file Ground.java
 */
public class Ground extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Background");

	public Ground(int x, int y) {
		super(SPRITE, x, y);
	}

	public Ground() {
		super();
	}
	
}
