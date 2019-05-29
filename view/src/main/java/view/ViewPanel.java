package view;

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
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

	private static int DEFAULT_SPRITE_SIZE = 16;
	private static double ZOOM = 3.5;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
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

		if (this.getViewFrame().getModel().getMap().getPlayer() != null) {
			graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
			super.paintComponent(graphics);
			Image img = null;
			try {
				img = ImageIO.read(new File("..\\entity\\src\\main\\resources\\sprite\\Backgroundd.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			graphics.fillRect(0, 0, getWidth(), getHeight());
			graphics.drawImage(img, 0, 0, 1920, 1080, this);
//				((Graphics2D) graphics).translate(
//						-this.getViewFrame().getModel().getMap().getPlayer().getPosition().getX() * DEFAULT_SPRITE_SIZE
//								* ZOOM + this.getWidth() / 2,
//						-this.getViewFrame().getModel().getMap().getPlayer().getPosition().getY() * DEFAULT_SPRITE_SIZE
//								* ZOOM + this.getHeight() / 2);
			((Graphics2D) graphics).scale(ZOOM, ZOOM);

			for (int y = 0; y < this.getViewFrame().getModel().getMap().getWidth(); y++) {
				for (int x = 0; x < this.getViewFrame().getModel().getMap().getHeight(); x++) {
					graphics.drawImage(this.getViewFrame().getModel().getMap().getMapObjects(y, x).getSprite()
							.loadSprite(this.getViewFrame().getModel().getMap().getMapObjects(y, x).getSprite()
									.getSpriteName()),
							y * DEFAULT_SPRITE_SIZE, x * DEFAULT_SPRITE_SIZE, this);
				}
			}
		}

		// graphics.drawString(this.getViewFrame().getModel().getMap().getMapDesign(),
		// 0, 0);
	}
}
