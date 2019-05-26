package element;

public class Position {
	private int x;
	private int y;
	private int maxX = 1;
	private int maxY = 1;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position(Position position) {
		this(position.getX(), position.getY());
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = (x + this.maxX) % this.maxX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = (y + this.maxY) % this.maxY;
	}

	public void setMaxX(final int maxX) {
		this.maxX = maxX;
	}

	public void setMaxY(final int maxY) {
		this.maxY = maxY;
	}

}
