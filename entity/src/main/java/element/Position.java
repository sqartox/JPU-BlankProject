package element;

/**
 * The Class Position.
 *
 * @author Jean michel crapaud
 * The class Position
 * Saved as file Position.java
 */
public class Position {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;

	/**
	 * Instantiates a new position.
	 *
	 * @param x the x
	 * @param y the y
	 * @throws Exception exception
	 */
	// Sprite constructor
	public Position(int x, int y) throws Exception {
		// Set the X Element Position
		if((x < 0) || (x > 50)){
			throw new Exception("Position X out of range");
		}
		this.x = x;
		
		// Set the Y Element Position
		if((y < 0) || (y > 22)) {
			throw new Exception("Position Y out of range");
		}
		this.y = y;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	// Get the X Element Position
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	// Get the Y Element Position
	public int getY() {
		return y;
	}

}
