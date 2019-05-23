package mobileelements;

public class Player extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "player";
		explosive = false;
		falling = false;
		destructible = true;
	}
	
	public Player() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
