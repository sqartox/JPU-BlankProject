package controller;

import java.sql.SQLException;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 *
 * @author Jean michel crapaud
 * The class Controller
 * Saved as file Controller.java
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/** The map. */
	private int map;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	// Controller constructor
	public Controller(final IView view, final IModel model) {
		// Set the View
		this.setView(view);
		// Set the Model
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		// Information message
		this.view.printMessage("Change map at antytime with numpad: 1-5");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	// Set the View
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	// Set the Model
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 * @throws Exception exception
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	// Get user orders
	public void orderPerform(final ControllerOrder controllerOrder) throws Exception {
		switch (controllerOrder) {
			// To choose the Map
			case Map1:
				this.setMap(1);
				break;
			case Map2:
				this.setMap(2);
				break;
			case Map3:
				this.setMap(3);
				break;
			case Map4:
				this.setMap(4);
				break;
			case Map5:
				this.setMap(5);
				break;
	
			// To Move Player
			case NOTHING:
				break;
			case UP:
				if (changeMap(0, -1)) {
					// Change to next Map
					this.setMap(this.getMap() + 1);
				} else {
					// Move the Player
					this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(1));
					// Notify changes
					this.model.modelNotify();
				}
				break;
			case DOWN:
				if (changeMap(0, +1)) {
					// Change to next Map
					this.setMap(this.getMap() + 1);
				} else {
					// Move the Player
					this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(2));
					// Notify changes
					this.model.modelNotify();
				}
				break;
			case LEFT:
				if (changeMap(-1, 0)) {
					// Change to next Map
					this.setMap(this.getMap() + 1);
				} else {
					// Move the Player
					this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(3));
					// Notify changes
					this.model.modelNotify();
				}
				break;
			case RIGHT:
				if (changeMap(+1, 0)) {
					// Change to next Map
					this.setMap(this.getMap() + 1);
				} else {
					// Move the Player
					this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(4));
					// Notify changes
					this.model.modelNotify();
				}
				break;
			default :
				throw new Exception("Invalid order");
			}
		
	}

	/**
	 * Change map.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
	// Change to next Map
	public boolean changeMap(int x, int y) {
		if (this.model.getMap().getPlayer().getDiamondCount() >= this.model.getMap().getTotalDiamonds()
				&& this.model.getMap().getPlayer().checkForExit(x, y)) {
			return true;
		}
		return false;
	}

	/**
	 * Play.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	// Game loop
	public final void play() throws InterruptedException {
		int moveOn = 1;
		while (true) {
			Thread.sleep(300);
			if (moveOn == 2) {
				// Refresh Opponents
				this.model.getMap().getOpponent().forEach((opponent) -> {
					try {
						opponent.refreshOpponents();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				// Notify changes
				this.model.modelNotify();
				moveOn = 1;
			} else {
				moveOn++;
			}
			// Refresh Stones
			this.model.getMap().getStone().forEach((stone) -> {
				try {
					stone.refreshStones();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			// Refresh Diamonds
			this.model.getMap().getDiamonds().forEach((diamond) -> {
				try {
					diamond.refreshDiamonds();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			// Notify changes
			this.model.modelNotify();
			// Stop the Game
			endOfGame();
		}

	}

	/**
	 * End of game.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	// Stop the Game
	public void endOfGame() throws InterruptedException {
		// Stop the Game if Player is dead
		if (this.model.getMap().getPlayer().isAlive() == false) {
			this.view.printMessage("Blurp !");
			System.exit(0);
		}
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	// Get the Map
	public int getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 * @throws Exception exception
	 * @throws SQLException SQLException
	 */
	// Set the Map
	public void setMap(int map) throws SQLException, Exception {
		// Set the Map
		this.map = map;
		// Load the Map
		this.model.loadMap(map);
		// Map information message
		this.view.printMessage("Current level: " + map);
	}

}
