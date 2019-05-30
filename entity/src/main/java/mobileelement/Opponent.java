package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Opponent.
 *
 * @author Jean michel crapaud
 * The class Opponent
 * Saved as file Opponent.java
 */
public class Opponent extends MobileElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Opponent");
	
	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;
	
	/** The Constant SPEED. */
	private static final int SPEED = 300;
	
	/** The state. */
	private boolean state;

	/**
	 * Instantiates a new opponent.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Opponent(int x, int y) {
		super(SPRITE, DIRECTION, x, y, SPEED);
		this.setState(true);
	}

	/**
	 * Move opponent.
	 */
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

	/**
	 * Refresh opponents.
	 */
	public void refreshOpponents() {
		if (this.isAlive()) {
			this.moveOpponent();
		}
	}

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
}
