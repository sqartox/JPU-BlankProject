package element;

public abstract class Element {

	private Sprite sprite;
	private Transparency transparency;

	public Element(final Sprite sprite, final Transparency transparency) {
		this.setSprite(sprite);
		this.setTranparency(transparency);
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
}
