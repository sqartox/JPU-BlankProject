package mobileelements;

public class Opponent extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "opponent";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public Opponent() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
