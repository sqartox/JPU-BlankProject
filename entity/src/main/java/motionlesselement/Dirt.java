package motionlesselement;

import element.Position;
import element.Sprite;
import element.Transparency;

public class Dirt extends MotionlessElement {

		private static final Sprite SPRITE = new Sprite("Dirt");
		private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
		
		public Dirt(Position position) {
			super(SPRITE, TRANSPARENCY, position);
		}
		
	    public Dirt() {
	        super(SPRITE, TRANSPARENCY, null);
	    }
}
