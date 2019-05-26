package mobileelement;

import element.Direction;
import element.Element;
import element.Map;
import element.Position;
import element.Sprite;
import element.Transparency;

public abstract class MobileElement extends Element {
	
	protected Direction direction;
	protected int speed;
	
	MobileElement(Sprite sprite, Transparency transparency, Position position, Direction direction, int speed) {
		super(sprite, transparency, position);
		this.direction = direction;
		this.speed = speed;
	}
	
	MobileElement() {
		super(null, Transparency.SOLID, null);
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
	
	public void placeInArea(final Map map) {
		this.position.setMaxX(map.getWidth());
		this.position.setMaxY(map.getHeight());
	}
	
	public void move() {
		switch (this.direction) {
			case UP:
				this.moveUp();
				break;
			case RIGHT:
				this.moveRight();
				break;
			case DOWN:
				this.moveDown();
				break;
			case LEFT:
				this.moveLeft();
				break;
			default:
				break;
		}
	}

	private void moveUp() {
		this.position.setY(this.position.getY() - this.speed);
	}

	private void moveRight() {
		this.position.setX(this.position.getX() + this.speed);
	}

	private void moveDown() {
		this.position.setY(this.position.getY() + this.speed);
	}

	private void moveLeft() {
		this.position.setX(this.position.getX() - this.speed);
	}
}
