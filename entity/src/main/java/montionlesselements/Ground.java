package montionlesselements;

public class Ground extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "Background";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public Ground() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
