package element;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Dirt;
import motionlesselement.Exit;
import motionlesselement.Ground;
import motionlesselement.IndoorWall;
import motionlesselement.Wall;

public class Map {
	private int id;
	private String level;

	private Element[][] mapObjects;
	private int totalDiamonds;

	/**
	 * Instantiates a new hello world.
	 */
	public Map(final int id, final String message) {
		this.setTotalDiamonds(0);
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
						this.setTotalDiamonds(this.getTotalDiamonds()+1);
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

	public Element getMapObjects(int x, int y) {
		return this.mapObjects[x][y];
	}
	
	public Element[][] getMapObjects(){
		return this.mapObjects;
	}
	
	 public Player getPlayer() {
	        Element[][] entity = this.getMapObjects();
	        for (int y = 0; y < getHeight(); y++) {
	            for (int x = 0; x < getWidth(); x++) {
	                if (entity[x][y] instanceof Player) {
	                    return (Player) entity[x][y];
	                }
	            }
	        }
	        return null;
	    }

	public int getTotalDiamonds() {
		return totalDiamonds;
	}

	public void setTotalDiamonds(int totalDiamonds) {
		this.totalDiamonds = totalDiamonds;
	}
}
