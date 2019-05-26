package element;

public abstract class Element {

	protected Sprite sprite;
	protected Transparency transparency;
	protected Position position;

	public Element(final Sprite sprite, final Transparency transparency, Position position) {
		this.setSprite(sprite);
		this.setTranparency(transparency);
		this.setPosition(position);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Transparency getTranparency() {
		return transparency;
	}

	public void setTranparency(Transparency tranparency) {
		this.transparency = tranparency;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
