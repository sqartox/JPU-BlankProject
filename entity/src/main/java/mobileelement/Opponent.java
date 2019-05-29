package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Opponent
 * Saved as file Opponent.java
 */
public class Opponent extends MobileElement {

	private static final Sprite SPRITE = new Sprite("Opponent");
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;

	public Opponent(int x, int y) {
		super(SPRITE, DIRECTION, x, y, SPEED);
	}

	public Opponent() {
		super();
	}

	public void moveOpponent() {
		int random = (int) (Math.random() * 4 + 1);
		switch (random) {
		case 1:
			this.changePosition(0, -1);
			break;
		case 2:
			this.changePosition(0, +1);
			break;
		case 3:
			this.changePosition(-1, 0);
			break;
		case 4:
			this.changePosition(+1, 0);
			break;
		default:
			break;
		}
	}

	public void refreshOpponents() {
		this.moveOpponent();
	}
}
