package mobileelement;

import element.Direction;
import element.Sprite;

/**
 * The Class Player.
 *
 * @author Jean michel crapaud
 * The class Player
 * Saved as file Player.java
 */
public class Player extends MobileElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite("Rockford");
    
    /** The Constant SPRITE_LEFT. */
    private static final Sprite SPRITE_LEFT = new Sprite("Left_Rockford");
    
    /** The Constant SPRITE_RIGHT. */
    private static final Sprite SPRITE_RIGHT = new Sprite("Right_Rockford");
    
    /** The Constant SPRITE_DOWN. */
    private static final Sprite SPRITE_DOWN = new Sprite("Down_Rockford");
	
	/** The Constant DIRECTION. */
	private static final Direction DIRECTION = null;
	
	/** The diamond count. */
	private int diamondCount;
	
	/** The state. */
	private boolean state;

	/**
	 * Instantiates a new player.
	 *
	 * @param player the player
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception 
	 */
	// Player constructor
	public Player(int player, int x, int y) throws Exception {
		// Call the Mobile Element constructor to instantiate a new Mobile Element
		super(SPRITE_DOWN, DIRECTION, x, y);
		// Set the Player Diamond count
		if( diamondCount < 0) {
			throw new Exception("Diamond count out of range");
		}
		this.diamondCount = 0;
		// Set the Player life state
		this.setState(true);
	}

	/**
	 * Gets the diamond count.
	 *
	 * @return the diamond count
	 */
	// Get the Player Diamond count
	public int getDiamondCount() {
		return this.diamondCount;
	}

	/**
	 * Sets the diamond count.
	 *
	 * @param diamondCount the new diamond count
	 * @throws Exception exception
	 */
	// Set the Player Diamond count
	public void setDiamondCount(int diamondCount) throws Exception{
		if (diamondCount < 0) {
			throw new Exception("Diamond count out of range");
		}
		this.diamondCount = diamondCount;
	}

	/**
	 * Move player.
	 *
	 * @param direction the direction
	 * @throws Exception exception
	 */
	// Move Player method
	public void movePlayer(Direction direction) throws Exception {
		switch (direction) {
		case UP:
			// Change Player position
			this.changePosition(0, -1);
			// Set the good Player's Sprite 
			this.setSprite(SPRITE);
			break;
		case DOWN:
			this.changePosition(0, +1);
			this.setSprite(SPRITE_DOWN);
			break;
		case LEFT:
			this.changePosition(-1, 0);
			this.setSprite(SPRITE_LEFT);
			break;
		case RIGHT:
			this.changePosition(+1, 0);
			this.setSprite(SPRITE_RIGHT);
			break;
		case NOTHING:
			break;
		}
	}

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	// Check if Player is alive
	public boolean isAlive() {
		return this.state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	// Set the Player life state
	public void setState(boolean state) {
		this.state = state;
	}
}
