package mobileelement;

import contract.Direction;
import element.Sprite;
import element.Transparency;

public class Stone extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Stone");
	private static final Transparency TRANSPARENCY = Transparency.SOLID;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;

	public Stone(int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
	}

	public Stone() {
		super();
	}
}
