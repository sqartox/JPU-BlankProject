package mobileelement;

import contract.Direction;
import element.Sprite;
import element.Transparency;

public class Diamond extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Diamond");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;

	public Diamond(int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
	}

	public Diamond() {
		super();
	}
}
