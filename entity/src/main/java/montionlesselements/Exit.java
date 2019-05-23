package montionlesselements;

public class Exit extends MotionlessElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "exit";
		explosive = false;
		falling = false;
		destructible = false;
	}
	
	public Exit() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
