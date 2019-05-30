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
	
	/** The Constant SPEED. */
	private static final int SPEED = 300;
	
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
	 */
	public Player(int player, int x, int y) {
		super(SPRITE_DOWN, DIRECTION, x, y, SPEED);
		this.diamondCount = 0;
		this.setState(true);
	}

	/**
	 * Gets the diamond count.
	 *
	 * @return the diamond count
	 */
	public int getDiamondCount() {
		return this.diamondCount;
	}

	/**
	 * Sets the diamond count.
	 *
	 * @param diamondCount the new diamond count
	 */
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	/**
	 * Move player.
	 *
	 * @param direction the direction
	 */
	public void movePlayer(Direction direction) {
		switch (direction) {
		case UP:
			this.changePosition(0, -1);
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
	public boolean isAlive() {
		return this.state;
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
