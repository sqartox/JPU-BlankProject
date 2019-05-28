package element;

import mobileelement.Opponent;
import mobileelement.Player;
import mobileelement.Stone;
import motionlesselement.Exit;
import motionlesselement.Ground;
import motionlesselement.IndoorWall;
import motionlesselement.Wall;

public class Collision {

	private Map map;

	public Collision(Map map) {
		this.map = map;
	}

	public boolean checkCollision(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		if (element instanceof Opponent) {
			this.map.getPlayer().setState(false);
		}
		if ((element instanceof Wall) || (element instanceof IndoorWall) || (element instanceof Stone)
				|| (element instanceof Exit)) {
			return false;
		}
		return true;
	}

	public boolean checkOpponentCollision(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		if ((element instanceof Ground)) {
			return true;
		}
		if (element instanceof Player) {
			this.map.getPlayer().setState(false);
		}
		return false;
	}

	public boolean checkStoneCollision(int x, int y, boolean isfalling) {
		Element element = this.map.getMapObjects(x, y);
		if ((element instanceof Ground)) {
			return true;
		}
		if (element instanceof Player && isfalling) {
			this.map.getPlayer().setState(false);
		}
		return false;
	}

	public boolean checkForStoneBellow(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		if (element instanceof Stone) {
			return true;
		}
		return false;
	}

	public void moveStoneOnStone(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		Element elementRight = this.map.getMapObjects(x + 1, y);
		Element elementDownRight = this.map.getMapObjects(x + 1, y - 1);
		Element elementLeft = this.map.getMapObjects(x - 1, y);
		Element elementDownLeft = this.map.getMapObjects(x - 1, y - 1);
		if (element instanceof Stone) {
			if (elementRight instanceof Ground && elementDownRight instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(4));
			}
		}
		if (element instanceof Stone) {
			if (elementLeft instanceof Ground && elementDownLeft instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(3));
			}
		}
	}
}
