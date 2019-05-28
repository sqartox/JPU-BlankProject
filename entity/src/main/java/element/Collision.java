package element;

import mobileelement.*;
import motionlesselement.*;

public class Collision {

	private Map map;

	public Collision(Map map) {
		this.map = map;
	}

	public boolean checkCollision(int x, int y) {
		Element element = this.map.getMapObjects(x, y);
		if (element instanceof Opponent) {
			this.map.getPlayer().setState("Dead");
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
			this.map.getPlayer().setState("Dead");
		}
		return false;
	}
}
