package element;

import contract.Direction;
import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import motionlesselement.Exit;
import motionlesselement.Ground;

public abstract class Element {

	protected Sprite sprite;
	protected Transparency transparency;
	protected Position position;
	protected Direction direction;
	private Map map;
	private Collision collision;

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

	// Change position
	public void changePosition(int x, int y) {
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		Element[][] objects = this.getMap().getMapObjects();
		this.collision = new Collision(this.map);
		if (this instanceof Player) {
			if (this.collision.checkCollision(currentX + x, currentY + y)) {
				this.getDiamond(currentX + x, currentY + y);
				objects[currentX + x][currentY + y] = objects[currentX][currentY];
				objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
		if (this instanceof Opponent) {
			if (this.collision.checkOpponentCollision(currentX + x, currentY + y)) {
				objects[currentX + x][currentY + y] = objects[currentX][currentY];
				objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
	}
	
	public boolean checkForExit(int x, int y) {
		int currentX = this.getPosition().getX();
		int currentY = this.getPosition().getY();
		if (this.getMap().getMapObjects(currentX + x, currentY + y) instanceof Exit) {
			return true;
		}
		return false;
	}
	
	public void getDiamond(int x, int y) {
		Player player = this.getMap().getPlayer();
		if (this.getMap().getMapObjects(x, y) instanceof Diamond) {
			player.setDiamondCount(player.getDiamondCount()+1);
			System.out.println(player.getDiamondCount());
		}
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
