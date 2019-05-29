package mobileelement;

import element.Direction;
import element.Element;
import element.Sprite;

/**
 * @author Jean michel crapaud The class MobileElement Saved as file
 *         MobileElement.java
 */
public abstract class MobileElement extends Element {

	protected Direction direction;
	protected int speed;

	/**
	 * @param sprite
	 * @param transparency
	 * @param direction
	 * @param x
	 * @param y
	 * @param speed
	 */
	MobileElement(Sprite sprite, Direction direction, int x, int y, int speed) {
		super(sprite, x, y);
		this.direction = direction;
		this.speed = speed;
	}
	
	/**
	 * @param choice
	 * @return
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
