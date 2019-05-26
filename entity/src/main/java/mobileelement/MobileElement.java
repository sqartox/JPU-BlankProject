package mobileelement;

import element.Element;
import element.Sprite;
import element.Transparency;

public abstract class MobileElement extends Element {
	MobileElement(Sprite sprite, Transparency transparency) {
		super(sprite, transparency);
		// TODO Auto-generated constructor stub
	}
	
	MobileElement() {
		super(null, Transparency.SOLID);
		// TODO Auto-generated constructor stub
	}
}
