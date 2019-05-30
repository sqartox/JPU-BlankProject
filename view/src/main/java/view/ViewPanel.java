package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Jean michel crapaud The class ViewPanel Saved as file ViewPanel.java
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

	private static int DEFAULT_SPRITE_SIZE = 16;
	private static boolean LARGECAMERA = true;
	private double zoom = 2.4;
	private Image img;
	private String mapDesign;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.img = null;
		try {
			img = ImageIO.read(new File("..\\entity\\src\\main\\resources\\sprite\\Font.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapDesign = this.getViewFrame().getModel().getMap().getMapDesign();
		this.getViewFrame().setTotalCount(0);
		this.getViewFrame().setCount(0);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {

		if (this.getViewFrame().getModel().getMap().getMapDesign() != mapDesign) {
			this.getViewFrame().setCount(0);
		}
		if (this.getViewFrame().getModel().getMap().getPlayer() != null) {
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			super.paintComponent(graphics);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			graphics.drawImage(img, 0, 0, 1920, 1080, this);
			if (LARGECAMERA == false) {
				this.zoom = 3.5;
				((Graphics2D) graphics).translate(
						-this.getViewFrame().getModel().getMap().getPlayer().getPosition().getX() * DEFAULT_SPRITE_SIZE
								* zoom + this.getWidth() / 2,
						-this.getViewFrame().getModel().getMap().getPlayer().getPosition().getY() * DEFAULT_SPRITE_SIZE
								* zoom + this.getHeight() / 2);
			}
			if (LARGECAMERA) {
				this.zoom = 2.4;
				((Graphics2D) graphics).translate(0, 120);
			}
			((Graphics2D) graphics).scale(zoom, zoom);

			for (int y = 0; y < this.getViewFrame().getModel().getMap().getWidth(); y++) {
				for (int x = 0; x < this.getViewFrame().getModel().getMap().getHeight(); x++) {
					graphics.drawImage(
							this.getViewFrame().getModel().getMap().getMapObjects(y, x).getSprite().getImage(),
							y * DEFAULT_SPRITE_SIZE, x * DEFAULT_SPRITE_SIZE, this);
				}
			}
		}
		graphics.setColor(new Color(0xFFFFFF));
		graphics.drawString("Total time: " + String.format("%.1f", this.getViewFrame().getTotalCount()), 10, -20);
		graphics.drawString("Level time: " + String.format("%.1f", this.getViewFrame().getCount()), 10, -5);
		if (this.getViewFrame().getModel().getMap().getPlayer() != null) {
			graphics.drawString("Current diamonds: "
					+ this.getViewFrame().getModel().getMap().getPlayer().getDiamondCount() + "/10 (needed)", 610, -5);
		}
		// graphics.drawString(this.getViewFrame().getModel().getMap().getMapDesign(),
		// 0, 0);

		mapDesign = this.getViewFrame().getModel().getMap().getMapDesign();
	}
}
