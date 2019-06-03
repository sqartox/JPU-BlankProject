package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Opponent.
 *
 * @author Jean michel crapaud The class Opponent Saved as file Opponent.java
 */
public class Opponent extends MobileElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Opponent");

	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;

	/** The state. */
	private boolean state;

	/**
	 * Instantiates a new opponent.
	 *
	 * @param x the x
	 * @param y the y
	 */
	// Opponent constructor
	public Opponent(int x, int y) {
		// Call the Mobile Element constructor to instantiate a new Mobile Element
		super(SPRITE, DIRECTION, x, y);
		// Set the Opponent life state
		this.setState(true);
	}

	/**
	 * Move opponent.
	 * @throws Exception exception
	 */
	// Move Opponent method
	public void moveOpponent() throws Exception {
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

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	// Check if Opponent is alive
	public boolean isAlive() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	// Set the Opponent life state
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * Refresh opponents.
	 * @throws Exception exception
	 */
	// Refresh Opponent position Method
	public void refreshOpponents() throws Exception {
		if (this.isAlive()) {
			this.moveOpponent();
		}
	}
}
