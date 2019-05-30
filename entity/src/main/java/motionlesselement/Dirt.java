package motionlesselement;

import element.Sprite;

/**
 * The Class Dirt.
 *
 * @author Jean michel crapaud
 * The class Dirt
 * Saved as file Dirt.java
 */
public class Dirt extends MotionlessElement {

		/** The Constant SPRITE. */
		private static final Sprite SPRITE = new Sprite("Dirt");
		
		/**
		 * Instantiates a new dirt.
		 *
		 * @param x the x
		 * @param y the y
		 */
		// Dirt constructor
		public Dirt(int x, int y) {
			// Call the Motionless Element constructor to instantiate a new Motionless Element
			super(SPRITE, x, y);
		}
}
