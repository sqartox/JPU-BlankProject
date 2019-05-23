package entity;

import java.util.Arrays;

public class Map extends Entity {
	private int id;
	private String level;
	private char[][] mapObject;

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
	
	public char getObject(int j, int i) {
		int position = i + j*22;
		return getMapDesign().replace("\n", "").charAt(position);
	}

	public void createMap() {
		int i = 0;
		int j = 0;
		if (getWidthOfMap() > 0) {
			this.mapObject = new char[getWidthOfMap()][getLinesOfMap()];
			for (i = 0; i < getLinesOfMap(); i++) {
				for (j = 0; j < getWidthOfMap(); j++) {
					this.mapObject[j][i] = getObject(j, i);
				}
			}
		}
		System.out.println(Arrays.deepToString(this.mapObject));
	}

}
