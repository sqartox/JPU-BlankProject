package montionlesselements;

public class Dirt extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "Dirt";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public Dirt(int x, int y) {
		super(sprite_name, x, y, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
