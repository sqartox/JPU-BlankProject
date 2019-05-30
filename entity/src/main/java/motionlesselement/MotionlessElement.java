package motionlesselement;

import element.Element;
import element.Sprite;

/**
 * The Class MotionlessElement.
 *
 * @author Jean michel crapaud
 * The class MotionlessElement
 * Saved as file MotionlessElement.java
 */
public abstract class MotionlessElement extends Element {
	
	/**
	 * Instantiates a new motionless element.
	 *
	 * @param sprite the sprite
	 * @param x the x
	 * @param y the y
	 */
	MotionlessElement(Sprite sprite, int x, int y) {
        super(sprite, x, y);
    }

}