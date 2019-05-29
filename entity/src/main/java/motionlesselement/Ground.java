package motionlesselement;

import element.Sprite;
import element.Transparency;

/**
 * @author Jean michel crapaud
 * The class Ground
 * Saved as file Ground.java
 */
public class Ground extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Background");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public Ground(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public Ground() {
		super();
	}
	
}
