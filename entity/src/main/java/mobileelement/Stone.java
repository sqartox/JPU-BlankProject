package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Stone.
 *
 * @author Jean michel crapaud
 * The class Stone
 * Saved as file Stone.java
 */
public class Stone extends MobileElement {
	
	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Stone");
	
	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;
	
	/** The Constant SPEED. */
	private static final int SPEED = 300;
	
	/** The isfalling. */
	private boolean isfalling;

	/**
	 * Instantiates a new stone.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Stone(int x, int y) {
		super(SPRITE, DIRECTION, x, y, SPEED);
		this.setIsfalling(false);
	}
	
	/**
	 * Move stone.
	 *
	 * @param direction the direction
	 */
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
	
	/**
	 * Refresh stones.
	 */
	public void refreshStones() {
		this.moveStone(Direction.DOWN);
	}

	/**
	 * Gets the checks if is falling.
	 *
	 * @return the checks if is falling
	 */
	public boolean getIsFalling() {
		return isfalling;
	}

	/**
	 * Sets the isfalling.
	 *
	 * @param isfalling the new isfalling
	 */
	public void setIsfalling(boolean isfalling) {
		this.isfalling = isfalling;
	}
	
}
