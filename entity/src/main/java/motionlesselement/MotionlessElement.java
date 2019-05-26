package motionlesselement;

import element.Element;
import element.Sprite;
import element.Transparency;

public abstract class MotionlessElement extends Element {
	
	MotionlessElement(final Sprite sprite, final Transparency transparency) {
        super(sprite, transparency);
    }
	
	MotionlessElement() {
        super(null, Transparency.TRANSPARENT);
    }
}