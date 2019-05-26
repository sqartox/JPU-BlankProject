package mobileelement;

import element.Direction;
import element.Sprite;
import element.Transparency;

public class Opponent extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Opponent");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;

	public Opponent(int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
	}

	public Opponent() {
		super();
	}
}
