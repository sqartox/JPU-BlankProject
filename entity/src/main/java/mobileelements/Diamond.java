package mobileelements;

public class Diamond extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "Diamond";
		explosive = true;
		falling = true;
		destructible = true;
	}
	
	public Diamond(int x, int y) {
		super(sprite_name, x, y, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
