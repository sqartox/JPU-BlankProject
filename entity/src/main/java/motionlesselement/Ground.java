package motionlesselement;

import element.Sprite;
import element.Transparency;

public class Ground extends MotionlessElement {

	private static final Sprite SPRITE = new Sprite("Dirt");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;

	public Ground(int x, int y) {
		super(SPRITE, TRANSPARENCY, x, y);
	}

	public Ground() {
		super();
	}
	
}
