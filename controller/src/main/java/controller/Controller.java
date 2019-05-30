package controller;

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
	public Controller(final IView view, final IModel model) {
		this.setView(view);
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
		this.view.printMessage("Change map at antytime with numpad: 1-5");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
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
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
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
		case NOTHING:
			break;
		case UP:
			if (changeMap(0, -1)) {
				this.setMap(this.getMap() + 1);
			} else {
				this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(1));
				this.model.modelNotify();
			}
			break;
		case DOWN:
			if (changeMap(0, +1)) {
				this.setMap(this.getMap() + 1);
			} else {
				this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(2));
				this.model.modelNotify();
			}
			break;
		case LEFT:
			if (changeMap(-1, 0)) {
				this.setMap(this.getMap() + 1);
			} else {
				this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(3));
				this.model.modelNotify();
			}
			break;
		case RIGHT:
			if (changeMap(+1, 0)) {
				this.setMap(this.getMap() + 1);
			} else {
				this.model.getMap().getPlayer().movePlayer(this.model.getMap().getPlayer().chooseDirection(4));
				this.model.modelNotify();
			}
			break;
		}
	}

	/**
	 * Change map.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
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
//Main while
	public final void play() throws InterruptedException {
		int moveOn = 1;
		while (true) {
			Thread.sleep(300);
			if (moveOn == 2) {
				this.model.getMap().getOpponent().forEach((opponent) -> opponent.refreshOpponents());
				this.model.modelNotify();
				moveOn = 1;
			} else {
				moveOn++;
			}
			this.model.getMap().getStone().forEach((stone) -> stone.refreshStones());
			this.model.getMap().getDiamonds().forEach((diamond) -> diamond.refreshDiamonds());
			this.model.modelNotify();
			endOfGame();
		}

	}

	/**
	 * End of game.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void endOfGame() throws InterruptedException {
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
	public int getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public void setMap(int map) {
		this.map = map;
		this.model.loadMap(map);
		this.view.printMessage("Current level: " + map);
	}

}
