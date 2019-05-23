package montionlesselements;

import entity.Ellements;

public abstract class MotionlessElements extends Ellements {
	private final static boolean movable = false;
	private final static boolean animated = false;
	
	public MotionlessElements(String sprite_name, boolean explosive, boolean falling, boolean destructible) {
		super(sprite_name, movable, animated, explosive, falling, destructible);
	}
}
