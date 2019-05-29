package motionlesselement;

import element.Sprite;

/**
 * @author Jean michel crapaud
 * The class Dirt
 * Saved as file Dirt.java
 */
public class Dirt extends MotionlessElement {

		private static final Sprite SPRITE = new Sprite("Dirt");
		
		public Dirt(int x, int y) {
			super(SPRITE, x, y);
		}
		
	    public Dirt() {
	        super();
	    }
}
