package montionlesselements;

public class Wall extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "wall";
		explosive = false;
		falling = false;
		destructible = false;
	}
	
	public Wall() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
