package mobileelement;

import element.Direction;
import element.Sprite;
import element.Transparency;

public class Diamond extends MobileElement {

	private static final Sprite SPRITE = new Sprite("Diamond");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;
	private boolean isfalling;

	public Diamond(int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
		this.setIsfalling(false);
	}

	public Diamond() {
		super();
	}
	
	public void moveDiamond(Direction direction) {
		switch (direction) {
		case DOWN:
			this.changePosition(0, +1);
			break;
		case LEFT:
			this.changePosition(-1, 0);
			break;
		case RIGHT:
			this.changePosition(+1, 0);
			break;
		default:
			break;
		}
	}

	public boolean getIsFalling() {
		return isfalling;
	}

	public void setIsfalling(boolean isfalling) {
		this.isfalling = isfalling;
	}

	public void refreshDiamonds() {
		this.moveDiamond(Direction.DOWN);
	}
}
