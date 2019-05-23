package montionlesselements;

public class IndoorWall extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "empty_path";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public IndoorWall() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
