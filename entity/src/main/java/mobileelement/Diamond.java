package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Diamond.
 *
 * @author Jean michel crapaud The class Diamond Saved as file Diamond.java
 */
public class Diamond extends MobileElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Diamond");

	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;

	/** The isfalling. */
	private boolean isfalling;

	/**
	 * Instantiates a new diamond.
	 *
	 * @param x the x
	 * @param y the y
	 */
	// Diamond constructor
	public Diamond(int x, int y) {
		// Call the Mobile Element constructor to instantiate a new Mobile Element
		super(SPRITE, DIRECTION, x, y);
		//Set the Diamond gravity state
		this.setIsfalling(false);
	}

	/**
	 * Move diamond.
	 *
	 * @param direction the direction
	 * @throws Exception exception
	 */
	// Move Diamonds method
	public void moveDiamond(Direction direction) throws Exception {
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
	//Check if Diamonds is falling method
	public boolean getIsFalling() {
		return isfalling;
	}

	/**
	 * Sets the isfalling.
	 *
	 * @param isfalling the new isfalling
	 */
	//Set the Diamond gravity state
	public void setIsfalling(boolean isfalling) {
		this.isfalling = isfalling;
	}

	/**
	 * Refresh diamonds.
	 * @throws Exception exception
	 */
	//Refresh Diamond position Method
	public void refreshDiamonds() throws Exception {
		this.moveDiamond(Direction.DOWN);
	}
}
