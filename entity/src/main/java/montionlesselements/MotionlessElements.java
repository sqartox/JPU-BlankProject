package montionlesselements;

import entity.Elements;

public abstract class MotionlessElements extends Elements {
	private final static boolean movable = false;
	private final static boolean animated = false;
	
	public MotionlessElements(String sprite_name, boolean explosive, boolean falling, boolean destructible) {
		super(sprite_name, movable, animated, explosive, falling, destructible);
	}
}
