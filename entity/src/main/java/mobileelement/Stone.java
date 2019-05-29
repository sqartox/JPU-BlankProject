package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Stone
 * Saved as file Stone.java
 */
public class Stone extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Stone");
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;
	private boolean isfalling;

	public Stone(int x, int y) {
		super(SPRITE, DIRECTION, x, y, SPEED);
		this.setIsfalling(false);
	}

	public Stone() {
		super();
	}
	
	public void moveStone(Direction direction) {
		switch (direction) {
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
	
	public void refreshStones() {
		this.moveStone(Direction.DOWN);
	}

	public boolean getIsFalling() {
		return isfalling;
	}

	public void setIsfalling(boolean isfalling) {
		this.isfalling = isfalling;
	}
	
}
