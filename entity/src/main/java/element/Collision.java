package element;

import mobileelement.Diamond;
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
		if (this.map.getMapObjects(x, y) instanceof Opponent) {
			this.map.getPlayer().setState(false);
		}
		if ((this.map.getMapObjects(x, y) instanceof Wall) || (this.map.getMapObjects(x, y) instanceof IndoorWall)
				|| (this.map.getMapObjects(x, y) instanceof Stone) || (this.map.getMapObjects(x, y) instanceof Exit)) {
			return false;
		}
		return true;
	}

	public boolean checkOpponentCollision(int x, int y) {
		if ((this.map.getMapObjects(x, y) instanceof Ground)) {
			return true;
		}
		if (this.map.getMapObjects(x, y) instanceof Player) {
			this.map.getPlayer().setState(false);
		}
		return false;
	}

	public boolean checkCollisionOnPlayer(int x, int y, boolean isfalling) {
		if ((this.map.getMapObjects(x, y) instanceof Ground)) {
			return true;
		}
		if (this.map.getMapObjects(x, y) instanceof Player && isfalling) {
			this.map.getPlayer().setState(false);
		}
		return false;
	}

	public boolean checkBellow(int x, int y) {
		if (this.map.getMapObjects(x, y) instanceof Stone) {
			return true;
		}
		if (this.map.getMapObjects(x, y) instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	public void moveStoneByPlayer(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		Element elementRight = this.map.getMapObjects(x + 1, y);
		Element elementLeft = this.map.getMapObjects(x - 1, y);
		if (element instanceof Stone) {
			if (elementRight instanceof Player && elementLeft instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(3));
			} else if (elementLeft instanceof Player && elementRight instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(4));
			}
		}
	}

	public void gravityFall(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		Element elementRight = this.map.getMapObjects(x + 1, y);
		Element elementDownRight = this.map.getMapObjects(x + 1, y + 1);
		Element elementLeft = this.map.getMapObjects(x - 1, y);
		Element elementDownLeft = this.map.getMapObjects(x - 1, y + 1);
		if (element instanceof Stone) {
			if (elementRight instanceof Ground && elementDownRight instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(4));
			} else if (elementLeft instanceof Ground && elementDownLeft instanceof Ground) {
				((Stone) element).moveStone(((Stone) element).chooseDirection(3));
			}
		}
		if (element instanceof Diamond) {
			if (elementRight instanceof Ground && elementDownRight instanceof Ground) {
				((Diamond) element).moveDiamond(((Diamond) element).chooseDirection(4));
			} else if (elementLeft instanceof Ground && elementDownLeft instanceof Ground) {
				((Diamond) element).moveDiamond(((Diamond) element).chooseDirection(3));
			}
		}
	}
}
