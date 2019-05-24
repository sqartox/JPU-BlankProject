package mobileelements;

import entity.Elements;

public abstract class MobileElements extends Elements {
	private final static boolean movable = true;
	private final static boolean animated = true;
	
	private int x;
	private int y;
	
	public MobileElements(String sprite_name,int x, int y, boolean explosive, boolean falling, boolean destructible) {
		super(sprite_name, x, y,  movable, animated, explosive, falling, destructible);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
