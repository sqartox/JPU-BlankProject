package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Wall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");

    /**
     * Instantiates a new Exit.
     */
    public Wall() {
        super(SPRITE, Transparency.TRANSPARENT);
    }
}
