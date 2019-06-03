package element;

import java.util.ArrayList;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Dirt;
import motionlesselement.Exit;
import motionlesselement.Ground;
import motionlesselement.IndoorWall;
import motionlesselement.Wall;

/**
 * The Class Map.
 *
 * @author Jean michel crapaud The class Map Saved as file Map.java
 */
public class Map {

	/** The level. */
	private String level;

	/** The map objects. */
	private Element[][] mapObjects;

	/** The totaldiamonds. */
	private static int TOTALDIAMONDS = 10;

	/** The stone. */
	private ArrayList<Stone> stone;

	/** The opponent. */
	private ArrayList<Opponent> opponent;

	/** The diamond. */
	private ArrayList<Diamond> diamond;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id 		the id
	 * @param message the message
	 * @throws Exception exception
	 */
	// Map constructor
	public Map(final int id, final String message) throws Exception {
		// Set the level Map design
		this.setMapDesign(message);
		// Set the different Map objects
		this.setMapObjects();
		// Make a Stone list
		stone = new ArrayList<Stone>();
		// Make a Opponent list
		opponent = new ArrayList<Opponent>();
		// Make a Diamond list
		diamond = new ArrayList<Diamond>();
	}

	/**
	 * Instantiates a new hello world.
	 * 
	 * @throws Exception exception
	 */// Map bis
	public Map() throws Exception {
		this(0, "");
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	// Get the level Map design
	public String getMapDesign() {
		return this.level;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	// Set the level Map design
	public void setMapDesign(final String message) {
		this.level = message.replace("\r", "");
		// Get the Map dimension
		getHeight();
		getWidth();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	// Get the vertical Map dimension
	public int getHeight() {
		int lines = this.level.split("\n").length;
//		System.out.println("Lines: " + lines);
		return lines;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	// Get the horizontal Map dimension
	public int getWidth() {
		String[] map = this.getMapDesign().split("\n");
//		System.out.println("Width: " + (map[0].length() - 1));
		return (map[0].length());
	}

	/**
	 * Sets the map objects.
	 * 
	 * @throws Exception exception
	 */
	// Set the different Map objects
	public void setMapObjects() throws Exception {
		// Get the level Map design
		String map = this.getMapDesign();
		System.out.println(map);
		System.out.println(getHeight());
		System.out.println(getWidth());
		if (getHeight() >= 1 && getWidth() >= 1) {
			// Crossed Map in order to create all the Map Elements
			this.mapObjects = new Element[this.getWidth()][this.getHeight()];
			for (int y = 0; y < getHeight(); y++) {
				String[] finalMap = map.split("\n");
				for (int x = 0; x < getWidth(); x++) {
					switch (finalMap[y].toCharArray()[x]) {
					case 'w':
						mapObjects[x][y] = new Wall(x, y);
						break;
					case 'g':
						mapObjects[x][y] = new Dirt(x, y);
						break;
					case 'p':
						mapObjects[x][y] = new Player(1, x, y);
						break;
					case 's':
						mapObjects[x][y] = new Stone(x, y);
						break;
					case 'r':
						mapObjects[x][y] = new Opponent(x, y);
						break;
					case 'n':
						mapObjects[x][y] = new Ground(x, y);
						break;
					case 'd':
						mapObjects[x][y] = new Diamond(x, y);
						break;
					case 'e':
						mapObjects[x][y] = new Exit(x, y);
						break;
					case 'i':
						mapObjects[x][y] = new IndoorWall(x, y);
						break;
					default:
						break;
					}
					mapObjects[x][y].setMap(this);
				}
			}
		}
	}

	/**
	 * Gets the map objects.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the map objects
	 */
	// Get the different Map objects with a position
	public Element getMapObjects(int x, int y) {
		return this.mapObjects[x][y];
	}

	/**
	 * Gets the map objects.
	 *
	 * @return the map objects
	 */
	// Set the different Map objects
	public Element[][] getMapObjects() {
		return this.mapObjects;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	// Get the Player in the Map
	public Player getPlayer() {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Player) {
					// Return the Player Map object
					return (Player) this.getMapObjects(x, y);
				}
			}
		}
		return null;
	}

	/**
	 * Gets the opponent.
	 *
	 * @return the opponent
	 */
	// Get all the Opponents in the Map
	public ArrayList<Opponent> getOpponent() {
		this.opponent.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				Element element = this.getMapObjects(x, y);
				if (element instanceof Opponent) {
					if (element.getMap().getThisOpponent(x, y).isAlive()) {
						// Add all the Opponents to the Opponent list
						this.opponent.add((Opponent) this.getMapObjects(x, y));
					}
				}
			}
		}
		// Return all the Opponents Map objects
		return opponent;
	}

	/**
	 * Gets the stone.
	 *
	 * @return the stone
	 */
	// Get all the Stones in the Map
	public ArrayList<Stone> getStone() {
		this.stone.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Stone) {
					// Add all the Stone to the Stone list
					this.stone.add((Stone) this.getMapObjects(x, y));
				}
			}
		}
		// Return all the Stones Map objects
		return this.stone;
	}

	/**
	 * Gets the diamonds.
	 *
	 * @return the diamonds
	 */
	// Get all the Diamonds in the Map
	public ArrayList<Diamond> getDiamonds() {
		this.diamond.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Diamond) {
					// Add all the Diamonds to the Diamond list
					this.diamond.add((Diamond) this.getMapObjects(x, y));
				}
			}
		}
		// Return all the Diamonds Map objects
		return this.diamond;
	}

	/**
	 * Gets the this stone.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this stone
	 */
	// Get the Stone in a certain position
	public Stone getThisStone(int x, int y) {
		// Return the Stone Map object
		return (Stone) this.getMapObjects(x, y);
	}

	/**
	 * Gets the this opponent.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this opponent
	 */
	// Get the Opponent in a certain position
	public Opponent getThisOpponent(int x, int y) {
		// Return the Opponent Map object
		return (Opponent) this.getMapObjects(x, y);
	}

	/**
	 * Gets the this diamond.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this diamond
	 */
	// Get the Diamond in a certain position
	public Diamond getThisDiamond(int x, int y) {
		// Return the Diamond Map object
		return (Diamond) this.getMapObjects(x, y);
	}

	/**
	 * Gets the total diamonds.
	 *
	 * @return the total diamonds
	 */
	// Get the Player Diamond total count
	public int getTotalDiamonds() {
		return TOTALDIAMONDS;
	}
}
