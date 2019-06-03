package mobileelement;

import element.Direction;
import element.Element;
import element.Sprite;

/**
 * The Class MobileElement.
 *
 * @author Jean michel crapaud The class MobileElement Saved as file
 *         MobileElement.java
 */
public abstract class MobileElement extends Element {

	/** The direction. */
	protected Direction direction;

	/**
	 * Instantiates a new mobile element.
	 *
	 * @param sprite the sprite
	 * @param direction the direction
	 * @param x the x
	 * @param y the y
	 */
	//Mobile Element constructor
	MobileElement(Sprite sprite, Direction direction, int x, int y) {
		//Call the Element constructor to instantiate a new Mobile Element
		super(sprite, x, y);
		//Set the Mobile Element direction
		this.direction = direction;
	}
	
	/**
	 * Choose direction.
	 *
	 * @param choice the choice
	 * @return the direction
	 * @throws Exception exception
	 */
	//Set Mobiles direction method
	public Direction chooseDirection(int choice) throws Exception {
		switch (choice) {
		case 1:
			return Direction.UP;
		case 2:
			return Direction.DOWN;
		case 3:
			return Direction.LEFT;
		case 4:
			return Direction.RIGHT;
		default:
			throw new Exception("Expected Direction id out of range");
		}
	}
}
