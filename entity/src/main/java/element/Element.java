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
	public Element(final Sprite sprite, int x, int y) {
		this.setSprite(sprite);
		this.setPosition(x, y);
	}

	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite the new sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Gets the position.
	 *
	 * @return Position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}

	/**
	 * Change position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void changePosition(int x, int y) {
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		this.objects = this.getMap().getMapObjects();
		this.collision = new Collision(this.map);
		if (this instanceof Player) {
			this.collision.moveStoneByPlayer(currentX + x, currentY);
			if (this.collision.checkCollision(currentX + x, currentY + y)) {
				this.getDiamond(currentX + x, currentY + y);
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
		if (this instanceof Opponent) {
			if (this.collision.checkOpponentCollision(currentX + x, currentY + y)) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			} else {
				Opponent opponent = (Opponent) this;
				opponent.refreshOpponents();
			}
		}

		if (this instanceof Stone)

		{
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisStone(currentX, currentY).getIsFalling())) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				this.getMap().getThisStone(currentX + x, currentY + y).setIsfalling(true);
			} else {
				this.getMap().getThisStone(currentX, currentY).setIsfalling(false);
			}
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
			}
		}
		if (this instanceof Diamond) {
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisDiamond(currentX, currentY).getIsFalling())) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				this.getMap().getThisDiamond(currentX + x, currentY + y).setIsfalling(true);
			} else {
				this.getMap().getThisDiamond(currentX, currentY).setIsfalling(false);
			}
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
			}
		}
	}

	/**
	 * Check for exit.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	public boolean checkForExit(int x, int y) {
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		if (this.getMap().getMapObjects(currentX + x, currentY + y) instanceof Exit) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the diamond.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the diamond
	 */
	public void getDiamond(int x, int y) {
		Element element = this.getMap().getMapObjects(x, y);
		if (element instanceof Diamond) {
			this.getMap().getPlayer().setDiamondCount(this.getMap().getPlayer().getDiamondCount() + 1);
			System.out.println(this.getMap().getPlayer().getDiamondCount());
		}
		if (element instanceof Opponent) {
			if (((Opponent) element).isAlive() == false){
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
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public void setMap(Map map) {
		this.map = map;
	}
}
