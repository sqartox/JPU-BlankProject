package view;

import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Jean michel crapaud The class ViewFrame Saved as file ViewFrame.java
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel model;

	/** The controller. */
	private IController controller;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;
	
	/** The count. */
	private double count;
	
	/** The total count. */
	private double totalCount;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public double getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(double count) {
		this.count = count;
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @throws HeadlessException the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model the model
	 */
	private void buildViewFrame(final IModel model) {
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setCursor(blankCursor);
		ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          count = count + 0.1;
		          totalCount = totalCount + 0.1;
		      }
		  };
		  new Timer(100, taskPerformer).start();
	}

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Key typed.
	 *
	 * @param e the e
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/**
	 * Key pressed.
	 *
	 * @param e the e
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/**
	 * Key released.
	 *
	 * @param e the e
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}

	/**
	 * Gets the total count.
	 *
	 * @return the total count
	 */
	public double getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount the new total count
	 */
	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
}
