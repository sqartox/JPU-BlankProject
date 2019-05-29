package motionlesselement;

import element.Sprite;
import element.Transparency;

/**
 * @author Jean michel crapaud
 * The class Dirt
 * Saved as file Dirt.java
 */
public class Dirt extends MotionlessElement {

		private static final Sprite SPRITE = new Sprite("Dirt");
		private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
		
		public Dirt(int x, int y) {
			super(SPRITE, TRANSPARENCY, x, y);
		}
		
	    public Dirt() {
	        super();
	    }
}
