package element;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Exit;
import motionlesselement.Ground;
import motionlesselement.IndoorWall;
import motionlesselement.Wall;

/**
 * The Class Collision.
 *
 * @author Jean michel crapaud The class Collision Saved as file Collision.java
 */
public class Collision {

	/** The map. */
	private Map map;

	/**
	 * Instantiates a new collision.
	 *
	 * @param map the map
	 */
	// Element constructor
	public Collision(Map map) {
		this.map = map;
	}

	/**
	 * Check collision.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	// Check Player Collision
	public boolean checkCollision(int x, int y) {
		// Get the Collision Element
		Element element = this.map.getMapObjects(x, y);
		// If is an Opponent
		if (element instanceof Opponent) {
			if (((Opponent) element).isAlive()) {
				// Killed Player if the Opponent is alive
				this.map.getPlayer().setState(false);
			}
		}
		// If is a basic Element
		if ((element instanceof Wall) || (element instanceof IndoorWall) || (element instanceof Stone)
				|| (element instanceof Exit)) {
			return false;
		}
		return true;
	}

	/**
	 * Check opponent collision.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	// Check Opponent Collision
	public boolean checkOpponentCollision(int x, int y) {
		// Check Ground Opponent Collision
		if ((this.map.getMapObjects(x, y) instanceof Ground)) {
			return true;
		}
		// Check Player Opponent Collision
		if (this.map.getMapObjects(x, y) instanceof Player) {
			// Killed Player
			this.map.getPlayer().setState(false);
		}
		return false;
	}

	/**
	 * Check collision on player.
	 *
	 * @param x the x
	 * @param y the y
	 * @param isfalling the isfalling
	 * @return true, if successful
	 */
	// Check Collision on Player
	public boolean checkCollisionOnPlayer(int x, int y, boolean isfalling) {
		// Check Ground Collision
		if ((this.map.getMapObjects(x, y) instanceof Ground)) {
			return true;
		}
		// Check Player Collision
		if (this.map.getMapObjects(x, y) instanceof Player && isfalling) {
			this.map.getPlayer().setState(false);
		}
		if (this.map.getMapObjects(x, y) instanceof Opponent) {
			this.map.getThisOpponent(x, y).setState(false);
		}
		return false;
	}

	/**
	 * Check bellow.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	// Check Collision below Element
	public boolean checkBellow(int x, int y) {
		// Check Collision below Stone
		if (this.map.getMapObjects(x, y) instanceof Stone) {
			return true;
		}
		// Check Collision below Diamond
		if (this.map.getMapObjects(x, y) instanceof Diamond) {
			return true;
		}
		return false;
	}

	/**
	 * Move stone by player.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception
	 */
	// Check Collision to move Stone by Player
	public void moveStoneByPlayer(int x, int y) throws Exception {
		Element element = this.map.getMapObjects(x, y);
		if (element instanceof Stone) {
			// Get the right and left element of the stone
			Element elementRight = this.map.getMapObjects(x + 1, y);
			Element elementLeft = this.map.getMapObjects(x - 1, y);

			// Check Collision to move Stone left
			if (elementRight instanceof Player && elementLeft instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(3));
			}
			// Check Collision to move Stone right
			else if (elementLeft instanceof Player && elementRight instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(4));
			}
		}
	}

	/**
	 * Gravity fall.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception
	 */
	// Check Collision to move Stone or Diamond by gravity
	public void gravityFall(int x, int y) throws Exception {
		// Get the Elements around of the Stone or the Diamond
		Element element = this.map.getMapObjects(x, y);
		Element elementRight = this.map.getMapObjects(x + 1, y);
		Element elementDownRight = this.map.getMapObjects(x + 1, y + 1);
		Element elementLeft = this.map.getMapObjects(x - 1, y);
		Element elementDownLeft = this.map.getMapObjects(x - 1, y + 1);
		
		// Check Collision to move Stone by gravity
		if (element instanceof Stone) {
			// Check the Right falling possibility
			if (elementRight instanceof Ground && elementDownRight instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(4));
			}
			// Check the Left falling possibility
			else if (elementLeft instanceof Ground && elementDownLeft instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(3));
			}
		}
		// Check Collision to move Diamond by gravity
		if (element instanceof Diamond) {
			// Check the Right falling possibility
			if (elementRight instanceof Ground && elementDownRight instanceof Ground) {
				((Diamond) element).moveDiamond(((Diamond) element).chooseDirection(4));
			}
			// Check the Left falling possibility
			else if (elementLeft instanceof Ground && elementDownLeft instanceof Ground) {
				((Diamond) element).moveDiamond(((Diamond) element).chooseDirection(3));
			}
		}
	}
}
