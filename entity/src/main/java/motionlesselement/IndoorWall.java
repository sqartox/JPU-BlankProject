package motionlesselement;

import element.Sprite;
import element.Transparency;

public class IndoorWall extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Wall");

    /**
     * Instantiates a new Exit.
     */
    public IndoorWall() {
        super(SPRITE, Transparency.TRANSPARENT);
    }
}
