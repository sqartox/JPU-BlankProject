package mobileelements;

public class Opponent extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "...";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public Opponent(int x, int y) {
		super(sprite_name, x, y, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
