package mobileelement;

import element.Direction;
import element.Sprite;
import element.Transparency;

public class Player extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Rockford");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;

	public Player(int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
	}

	public Player() {
		super();
	}
}
