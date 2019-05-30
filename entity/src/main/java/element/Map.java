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
	 * @param id the id
	 * @param message the message
	 */
	public Map(final int id, final String message) {
		this.setMapDesign(message);
		this.setMapObjects();
		stone = new ArrayList<Stone>();
		opponent = new ArrayList<Opponent>();
		diamond = new ArrayList<Diamond>();
	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(0, "");
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMapDesign() {
		return this.level;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMapDesign(final String message) {
		this.level = message.replace("\r", "");
		getHeight();
		getWidth();
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
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
	public int getWidth() {
		String[] map = this.getMapDesign().split("\n");
//		System.out.println("Width: " + (map[0].length() - 1));
		return (map[0].length());
	}

	/**
	 * Sets the map objects.
	 */
	public void setMapObjects() {
		String map = this.getMapDesign();
		System.out.println(map);
		System.out.println(getHeight());
		System.out.println(getWidth());
		if (getHeight() >= 1 && getWidth() >= 1) {
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
	public Element getMapObjects(int x, int y) {
		return this.mapObjects[x][y];
	}

	/**
	 * Gets the map objects.
	 *
	 * @return the map objects
	 */
	public Element[][] getMapObjects() {
		return this.mapObjects;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Player) {
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
	public ArrayList<Opponent> getOpponent() {
		this.opponent.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				Element element = this.getMapObjects(x, y);
				if (element instanceof Opponent) {
					if (element.getMap().getThisOpponent(x, y).isAlive()) {
						this.opponent.add((Opponent) this.getMapObjects(x, y));
					}
				}
			}
		}
		return opponent;
	}

	/**
	 * Gets the this stone.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this stone
	 */
	public Stone getThisStone(int x, int y) {
		return (Stone) this.getMapObjects(x, y);
	}

	/**
	 * Gets the this opponent.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this opponent
	 */
	public Opponent getThisOpponent(int x, int y) {
		return (Opponent) this.getMapObjects(x, y);
	}

	/**
	 * Gets the this diamond.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the this diamond
	 */
	public Diamond getThisDiamond(int x, int y) {
		return (Diamond) this.getMapObjects(x, y);
	}

	/**
	 * Gets the stone.
	 *
	 * @return the stone
	 */
	public ArrayList<Stone> getStone() {
		this.stone.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Stone) {
					this.stone.add((Stone) this.getMapObjects(x, y));
				}
			}
		}
		return this.stone;
	}

	/**
	 * Gets the diamonds.
	 *
	 * @return the diamonds
	 */
	public ArrayList<Diamond> getDiamonds() {
		this.diamond.clear();
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (this.getMapObjects(x, y) instanceof Diamond) {
					this.diamond.add((Diamond) this.getMapObjects(x, y));
				}
			}
		}
		return this.diamond;
	}

	/**
	 * Gets the total diamonds.
	 *
	 * @return the total diamonds
	 */
	public int getTotalDiamonds() {
		return TOTALDIAMONDS;
	}
}
