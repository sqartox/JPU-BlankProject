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
		if ((element instanceof Wall)||(element instanceof IndoorWall)||(element instanceof Stone)){
			return false;
		}
		return true;
	}
}
