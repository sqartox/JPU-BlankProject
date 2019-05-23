package motionlesselements;

public class EmptyPath extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "Black";
		explosive = false;
		falling = false;
		destructible = false;
	}
	
	public EmptyPath(int x, int y) {
		super(sprite_name, x, y, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
