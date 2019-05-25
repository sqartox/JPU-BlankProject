package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
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
	 * @param viewFrame
	 *          the new view frame
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
		super.paintComponent(graphics);
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		((Graphics2D) graphics).scale(4.5 , 4.5);
		// graphics.drawString(this.getViewFrame().getModel().getMap().getMapDesign(),
		// 0, 0);

		Map map = this.getViewFrame().getModel().getMap();

		for (int y = 0; y < this.getViewFrame().getModel().getMap().getWidthOfMap(); y++) {
			for (int x = 0; x < this.getViewFrame().getModel().getMap().getLinesOfMap(); x++) {
				// FIXME: We currently need to swap the 'x' and 'y' coords in order to display
				// the playfield in the right order.
				graphics.drawImage(map.getMapObjects(y, x).loadSprite(map.getMapObjects(y, x).getSpriteName()),
						y * DEFAULT_SPRITE_SIZE, x * DEFAULT_SPRITE_SIZE, this);
			}
		}
	}
}
