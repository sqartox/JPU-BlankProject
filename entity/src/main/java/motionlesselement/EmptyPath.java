package motionlesselement;

import element.Sprite;
import element.Transparency;

public class EmptyPath extends MotionlessElement {
	private static final Sprite SPRITE = new Sprite("Black");

    /**
     * Instantiates a new EmptyPath.
     */
    public EmptyPath() {
        super(SPRITE, Transparency.TRANSPARENT);
    }

}
