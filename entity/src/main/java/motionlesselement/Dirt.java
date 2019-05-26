package motionlesselement;

import element.Sprite;
import element.Transparency;

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
