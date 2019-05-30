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
	
	/** The speed. */
	protected int speed;

	/**
	 * Instantiates a new mobile element.
	 *
	 * @param sprite the sprite
	 * @param direction the direction
	 * @param x the x
	 * @param y the y
	 * @param speed the speed
	 */
	MobileElement(Sprite sprite, Direction direction, int x, int y, int speed) {
		super(sprite, x, y);
		this.direction = direction;
		this.speed = speed;
	}
	
	/**
	 * Choose direction.
	 *
	 * @param choice the choice
	 * @return the direction
	 */
	public Direction chooseDirection(int choice) {
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
			return null;
		}
	}
}
