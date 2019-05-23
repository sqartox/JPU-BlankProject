package mobileelements;

public class Stone extends MobileElements {
	private static String sprite_name;
	private static boolean explosive;
	private static boolean falling;
	private static boolean destructible;
	
	static {
		sprite_name = "Stone";
		explosive = false;
		falling = true;
		destructible = false;
	}
	
	public Stone() {
		super(sprite_name, explosive, falling, destructible);
		
		this.loadSprite(sprite_name);
	}
}
