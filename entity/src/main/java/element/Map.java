package element;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.EmptyPath;
import motionlesselement.Exit;
import motionlesselement.Ground;
import motionlesselement.IndoorWall;
import motionlesselement.Wall;

public class Map {
	private int id;
	private String level;

	private Element[][] mapObject;

	/**
	 * Instantiates a new hello world.
	 */
	public Map(final int id, final String message) {
		this.setId(id);
		this.setMapDesign(message);
		this.setMapObjects();
	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(0, "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
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

	public int getHeight() {
		int lines = this.level.split("\n").length;
//		System.out.println("Lines: " + lines);
		return lines;
	}

	public int getWidth() {
		String[] map = this.getMapDesign().split("\n");
//		System.out.println("Width: " + (map[0].length() - 1));
		return (map[0].length());
	}

	public void setMapObjects() {
		String map = this.getMapDesign();
		System.out.println(map);
		System.out.println(getHeight());
		System.out.println(getWidth());
		if (getHeight() >= 1 && getWidth() >= 1) {
			this.mapObject = new Element[this.getWidth()][this.getHeight()];
			for (int y = 0; y < getHeight(); y++) {
				String[] finalMap = map.split("\n");
				for (int x = 0; x < getWidth(); x++) {
					switch (finalMap[y].toCharArray()[x]) {
					case 'w':
						mapObject[x][y] = new Wall(x, y);
						break;
					case 'g':
						mapObject[x][y] = new Ground(x, y);
						break;
					case 'p':
						mapObject[x][y] = new Player(x, y);
						break;
					case 's':
						mapObject[x][y] = new Stone(x, y);
						break;
					case 'r':
						mapObject[x][y] = new Opponent(x, y);
						break;
					case 'n':
						mapObject[x][y] = new EmptyPath(x, y);
						break;
					case 'd':
						mapObject[x][y] = new Diamond(x, y);
						break;
					case 'e':
						mapObject[x][y] = new Exit(x, y);
					case 'i':
						mapObject[x][y] = new IndoorWall(x, y);
						break;
					default:
						break;
					}
				}
			}
		}
	}

	public Element getMapObjects(int x, int y) {
		return this.mapObject[x][y];
	}
}
