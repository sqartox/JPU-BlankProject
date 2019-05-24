package entity;

import mobileelements.Diamond;
import mobileelements.Opponent;
import mobileelements.Player;
import mobileelements.Stone;
import motionlesselements.EmptyPath;
import motionlesselements.Exit;
import motionlesselements.Ground;
import motionlesselements.IndoorWall;
import motionlesselements.Wall;

public class Map extends Elements {
	private int id;
	private String level;
	private Elements[][] mapObject;

	/**
	 * Instantiates a new hello world.
	 */
	public Map(final int id, final String message) {
		this.setId(id);
		this.setMapDesign(message);
		this.createMap();
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
		getLinesOfMap();
		getWidthOfMap();
	}

	public int getLinesOfMap() {
		int lines = this.level.split("\n").length;
//		System.out.println("Lines: " + lines);
		return lines;
	}

	public int getWidthOfMap() {
		String[] map = this.getMapDesign().split("\n");
//		System.out.println("Width: " + (map[0].length() - 1));
		return (map[0].length());
	}

	public void createMap() {
		 String map = this.getMapDesign();
	        System.out.println(map);
	        System.out.println(getLinesOfMap());
	        System.out.println(getWidthOfMap());
	        if (getLinesOfMap() >= 1 && getWidthOfMap() >= 1) {
	            this.mapObject = new Elements[this.getWidthOfMap()][this.getLinesOfMap()];
	            for (int y = 0; y < getLinesOfMap(); y++) {
	                String[] finalMap = map.split("\n");
	                for (int x = 0; x < getWidthOfMap(); x++) {
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
}