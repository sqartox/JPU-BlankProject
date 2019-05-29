package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Exit
 * Saved as file Exit.java
 */
public class Exit extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Door");

	public Exit(int x, int y) {
		super(SPRITE, x, y);
	}

	public Exit() {
		super();
	}

}
