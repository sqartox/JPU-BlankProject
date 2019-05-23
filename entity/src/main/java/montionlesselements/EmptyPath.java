package montionlesselements;

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
	
	public EmptyPath() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
