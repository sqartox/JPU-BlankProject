package motionlesselement;

import element.Element;
import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class MotionlessElement
 * Saved as file MotionlessElement.java
 */
public abstract class MotionlessElement extends Element {
	
	MotionlessElement(Sprite sprite, int x, int y) {
        super(sprite, x, y);
    }
	
	MotionlessElement() {
        super(null, 0, 0);
    }
}