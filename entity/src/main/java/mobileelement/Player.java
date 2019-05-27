package mobileelement;

import element.Direction;
import element.Sprite;
import element.Transparency;

public class Player extends MobileElement {
	
	private static final Sprite SPRITE = new Sprite("Rockford");
	private static final Transparency TRANSPARENCY = Transparency.TRANSPARENT;
	private static final Direction DIRECTION = null;
	private static final int SPEED = 300;
	
	private final int player;

	public Player(int player, int x, int y) {
		super(SPRITE, TRANSPARENCY, DIRECTION, x, y, SPEED);
		this.player = player;
	}

	public Player(int player) {
		super();
		this.player = player;
	}

	public int getPlayer() {
		return player;
	}
	
	public boolean isPlayer(final int player) {
		return this.player == player;	}
	
	public void movePlayer(Direction direction) {
		switch(direction) {
		case UP:
			this.changePosition(0, -1);
			break;
		case DOWN:
			this.changePosition(0, +1);
			break;
		case LEFT:
			this.changePosition(-1, 0);
			break;
		case RIGHT:
			this.changePosition(+1, 0);
			break;
		case NOTHING:
			this.changePosition(0, 0);
			break;
		}
	}

	public boolean isAlive() {
		return true;
	}
}
