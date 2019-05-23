package motionlesselements;

import entity.Elements;

public abstract class MotionlessElements extends Elements {
	private final static boolean movable = false;
	private final static boolean animated = false;
	
	public MotionlessElements(String sprite_name, int x, int y, boolean explosive, boolean falling, boolean destructible) {
		super(sprite_name, x, y, movable, animated, explosive, falling, destructible);
	}
}
