package mobileelements;

import entity.Ellements;

public abstract class MobileElements extends Ellements {
	private final static boolean movable = true;
	private final static boolean animated = true;
	
	public MobileElements(String sprite_name, boolean explosive, boolean falling, boolean destructible) {
		super(sprite_name, movable, animated, explosive, falling, destructible);
	}
}
