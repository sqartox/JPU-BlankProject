package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Exit extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Exit");

    /**
     * Instantiates a new Exit.
     */
    public Exit() {
        super(SPRITE, Transparency.TRANSPARENT);
    }
	
}
