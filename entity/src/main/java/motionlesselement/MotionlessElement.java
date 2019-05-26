package motionlesselement;

import element.Element;
import element.Sprite;
import element.Transparency;

public abstract class MotionlessElement extends Element {
	
	MotionlessElement(Sprite sprite, Transparency transparency, int x, int y) {
        super(sprite, transparency, x, y);
    }
	
	MotionlessElement() {
        super(null, Transparency.TRANSPARENT, 0, 0);
    }
}