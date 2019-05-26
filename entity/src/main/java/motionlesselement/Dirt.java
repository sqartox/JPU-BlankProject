package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Dirt extends MotionlessElement {

		private static final Sprite SPRITE = new Sprite("Dirt");

	    /**
	     * Instantiates a new Dirt Bloc.
	     */
	    public Dirt() {
	        super(SPRITE, Transparency.TRANSPARENT);
	    }
}
