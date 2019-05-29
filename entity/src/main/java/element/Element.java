package element;

import mobileelement.Diamond;
import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Exit;
import motionlesselement.Ground;

public abstract class Element {

	protected Sprite sprite;
	protected Transparency transparency;
	protected Position position;
	private Map map;
	private Collision collision;
	private Element[][] objects;

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
		this.objects = this.getMap().getMapObjects();
		this.collision = new Collision(this.map);
		if (this instanceof Player) {
			this.collision.moveStoneByPlayer(currentX + x, currentY);
			if (this.collision.checkCollision(currentX + x, currentY + y)) {
				this.getDiamond(currentX + x, currentY + y);
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
		if (this instanceof Opponent) {
			if (this.collision.checkOpponentCollision(currentX + x, currentY + y)) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
			}
		}
		if (this instanceof Stone) {
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisStone(currentX, currentY).getIsFalling())) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				this.getMap().getThisStone(currentX + x, currentY + y).setIsfalling(true);
			} else {
				this.getMap().getThisStone(currentX, currentY).setIsfalling(false);
			}
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
			}
		}
		if (this instanceof Diamond) {
			if (this.collision.checkCollisionOnPlayer(currentX + x, currentY + y,
					this.getMap().getThisDiamond(currentX, currentY).getIsFalling())) {
				this.objects[currentX + x][currentY + y] = this.objects[currentX][currentY];
				this.objects[currentX][currentY] = new Ground(currentX, currentY);
				this.setPosition(currentX + x, currentY + y);
				this.getMap().getThisDiamond(currentX + x, currentY + y).setIsfalling(true);
			} else {
				this.getMap().getThisDiamond(currentX, currentY).setIsfalling(false);
			}
			if (this.collision.checkBellow(currentX, currentY + 1)) {
				this.collision.gravityFall(currentX, currentY);
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
		if (this.getMap().getMapObjects(x, y) instanceof Diamond) {
			this.getMap().getPlayer().setDiamondCount(this.getMap().getPlayer().getDiamondCount() + 1);
		}
	}

	public boolean isPlayer(int player) {
		return false;
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
