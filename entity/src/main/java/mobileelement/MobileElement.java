package mobileelement;

import contract.Direction;
import element.Element;
import element.Sprite;
import element.Transparency;

public abstract class MobileElement extends Element {
	
	protected Direction direction;
	protected int speed;
	
	MobileElement(Sprite sprite, Transparency transparency, Direction direction, int x, int y, int speed) {
		super(sprite, transparency, x, y);
		this.direction = direction;
		this.speed = speed;
	}
	
	MobileElement() {
		super(null, Transparency.SOLID, 0, 0);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isPlayer(final int player) {
		return false;
	}
}
