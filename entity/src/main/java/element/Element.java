package element;

import motionlesselement.EmptyPath;

public abstract class Element {

	protected Sprite sprite;
	protected Transparency transparency;
	protected Position position;
	protected Direction direction;
	private Map map;

	public Element(final Sprite sprite, final Transparency transparency, int x, int y) {
		this.setSprite(sprite);
		this.setTranparency(transparency);
		this.setPosition(x, y);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Transparency getTranparency() {
		return transparency;
	}

	public void setTranparency(Transparency tranparency) {
		this.transparency = tranparency;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}
	
	public void changePosition(int x, int y) {
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		Element[][] objects = this.getMap().getMapObjects();
		
		objects[currentX + x][currentY + y] = objects[currentX][currentY];
		objects[currentX][currentY] = new EmptyPath(currentX, currentY);
		this.setPosition(currentX + x, currentY + y);
	}
	
	public boolean isPlayer(int player) {
		return false;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return this.direction;
	}
	
	public Map getMap() {
		return this.map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
}