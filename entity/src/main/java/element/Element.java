package element;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Exit;
import motionlesselement.Ground;

/**
 * The Class Element.
 *
 * @author Jean michel crapaud The class Element Saved as file Element.java
 */
public abstract class Element {

	/** The sprite. */
	protected Sprite sprite;
	
	/** The position. */
	protected Position position;
	
	/** The map. */
	private Map map;
	
	/** The collision. */
	private Collision collision;
	
	/** The objects. */
	private Element[][] objects;

	/**
	 * Instantiates a new element.
	 *
	 * @param sprite the sprite
	 * @param x the x
	 * @param y the y
	 */
	// Element constructor
	public Element(final Sprite sprite, int x, int y) {
		// Set the Element Sprite
		this.setSprite(sprite);
		// Set the Element position
		this.setPosition(x, y);
	}

	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	// Get the Element Sprite
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite the new sprite
	 */
	// Set the Element Sprite
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Gets the position.
	 *
	 * @return Position
	 */
	// Get the Element position
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	// Set the Element position
	public void setPosition(int x, int y) {
		try {
			this.position = new Position(x, y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Change position by checking collision depending type of element .
	 *
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception
	 */
	// Change the Element position
	public void changePosition(int x, int y) throws Exception {
		// Get the current X and Y pos in the Map
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		// Get the Element at the current pos
		this.objects = this.getMap().getMapObjects();
		// Check for collision
		this.collision = new Collision(this.map);
		// Player collisions
		if (this instanceof Player) {
			// Permit Player to push Stones
			this.collision.moveStoneByPlayer(currentX + x, currentY);
			// Check Collisions before moved Player
			if (this.collision.checkCollision(currentX + x, currentY + y)) {
				// Check if the Player is on a Diamond
				this.getDiamond(currentX + x, currentY + y);
				// Move the Player
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
		
		// Opponent collisions
		if (this instanceof Opponent) {
			// Check Collisions before moved Opponent
			if (this.collision.checkOpponentCollision(currentX + x, currentY + y)) {
				// Move the Opponent
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
			// Permit to deny a part of of random movements
			else {
				Opponent opponent = (Opponent) this;
				opponent.refreshOpponents();
			}
		}

		// Stone collisions
		if (this instanceof Stone) {
			// Check Collisions and gravity before moved Stone and kill Player
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisStone(currentX, currentY).getIsFalling())) {
				// Move the Stone
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				// Set state gravity to true
				this.getMap().getThisStone(currentX + x, currentY + y).setIsfalling(true);
			} else {
				// Set state gravity to false
				this.getMap().getThisStone(currentX, currentY).setIsfalling(false);
			}
			// Check Collisions before moved Stone
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
			}
		}

		// Diamond collisions
		if (this instanceof Diamond) {
			// Check Collisions and gravity before moved Diamond and kill Player
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisDiamond(currentX, currentY).getIsFalling())) {
				// Move the Diamond
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				// Set state gravity to true
				this.getMap().getThisDiamond(currentX + x, currentY + y).setIsfalling(true);
			} else {
				// Set state gravity to false
				this.getMap().getThisDiamond(currentX, currentY).setIsfalling(false);
			}
			// Check Collisions before moved Diamond
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
			}
		}
	}

	/**
	 * Check for exit around Player.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	// Check for Exit position
	public boolean checkForExit(int x, int y) {
		// Get the current X and Y pos in the Map
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		if (this.getMap().getMapObjects(currentX + x, currentY + y) instanceof Exit) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the diamond position and increment Diamond count when player got a new diamond.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception
	 */
	// Check for Diamond position and increment Diamond count
	public void getDiamond(int x, int y) throws Exception {
		Element element = this.getMap().getMapObjects(x, y);
		// Check for Diamond
		if (element instanceof Diamond) {
			// Increment Diamond count
			this.getMap().getPlayer().setDiamondCount(this.getMap().getPlayer().getDiamondCount() + 1);
			System.out.println(this.getMap().getPlayer().getDiamondCount());
		}
		// Check for dead Opponent
		if (element instanceof Opponent) {
			if (((Opponent) element).isAlive() == false){
				// Increment Diamond count if Opponent is dead
				this.getMap().getPlayer().setDiamondCount(this.getMap().getPlayer().getDiamondCount() + 2);
				System.out.println(this.getMap().getPlayer().getDiamondCount());
			}
		}
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	// Get the Map
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	// Get the Map
	public void setMap(Map map) {
		this.map = map;
	}
}
