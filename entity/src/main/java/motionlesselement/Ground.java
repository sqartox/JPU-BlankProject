package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Ground extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Background");

    /**
     * Instantiates a new Exit.
     */
    public Ground() {
        super(SPRITE, Transparency.TRANSPARENT);
    }
	
}
