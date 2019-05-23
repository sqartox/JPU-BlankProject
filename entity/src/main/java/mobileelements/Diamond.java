package mobileelements;

public class Diamond extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "empty_path";
		explosive = true;
		falling = true;
		destructible = true;
	}
	
	public Diamond() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
