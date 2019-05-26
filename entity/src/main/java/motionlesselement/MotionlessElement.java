package motionlesselement;

import element.Element;
import element.Position;
import element.Sprite;
import element.Transparency;

public abstract class MotionlessElement extends Element {
	
	MotionlessElement(Sprite sprite, Transparency transparency, Position position) {
        super(sprite, transparency, position);
    }
	
	MotionlessElement() {
        super(null, Transparency.TRANSPARENT, null);
    }
}