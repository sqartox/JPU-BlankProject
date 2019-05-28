package mobileelement;

import contract.Direction;
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

	public void moveOpponent(Direction direction) {
		switch (direction) {
		case UP:
			this.changePosition(0, -1);
			break;
		case DOWN:
			this.changePosition(0, +1);
			break;
		case LEFT:
			this.changePosition(-1, 0);
			break;
		case RIGHT:
			this.changePosition(+1, 0);
			break;
		default:
			break;
		}
	}

	public Direction randomDirection() {
		int random = (int) (Math.random() * 4 + 1);
		switch (random) {
		case 1:
			return Direction.UP;
		case 2:
			return Direction.DOWN;
		case 3:
			return Direction.LEFT;
		case 4:
			return Direction.RIGHT;
		default:
			return null;
		}
	}

	public void refreshOpponents() {
		this.moveOpponent(this.randomDirection());
	}
}
