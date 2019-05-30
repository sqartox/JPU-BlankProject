package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Stone.
 *
 * @author Jean michel crapaud The class Stone Saved as file Stone.java
 */
public class Stone extends MobileElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Stone");

	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;

	/** The isfalling. */
	private boolean isfalling;

	/**
	 * Instantiates a new stone.
	 *
	 * @param x the x
	 * @param y the y
	 */
	// Stone constructor
	public Stone(int x, int y) {
		// Call the Mobile Element constructor to instantiate a new Mobile Element
		super(SPRITE, DIRECTION, x, y);
		// Set the Stone gravity state
		this.setIsfalling(false);
	}

	/**
	 * Move stone.
	 *
	 * @param direction the direction
	 */
	// Move Stone method
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
	 * Gets the checks if is falling.
	 *
	 * @return the checks if is falling
	 */
	// Check if Stone is falling method
	public boolean getIsFalling() {
		return isfalling;
	}

	/**
	 * Sets the isfalling.
	 *
	 * @param isfalling the new isfalling
	 */
	//Set the Stone gravity state
	public void setIsfalling(boolean isfalling) {
		this.isfalling = isfalling;
	}

	/**
	 * Refresh stones.
	 */
	//Refresh Stone position Method
	public void refreshStones() {
		this.moveStone(Direction.DOWN);
	}

}
