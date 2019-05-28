package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import element.Direction;
import element.Map;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
	
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
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
			}
			this.model.getMap().getPlayer().movePlayer(Direction.UP);
			break;
		case DOWN:
			if (changeMap(0, +1)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
			}
			this.model.getMap().getPlayer().movePlayer(Direction.DOWN);
			break;
		case LEFT:
			if (changeMap(-1, 0)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
			}
			this.model.getMap().getPlayer().movePlayer(Direction.LEFT);
			break;
		case RIGHT:
			if (changeMap(+1, 0)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
			}
			this.model.getMap().getPlayer().movePlayer(Direction.RIGHT);
			break;
		}
	}
	
	public boolean changeMap(int x, int y) {
		Map map = this.model.getMap();
		if (map.getPlayer().getDiamondCount() == map.getTotalDiamonds() && map.getPlayer().checkForExit(x, y)) {
			return true;
		}
		return false;
	}
	
//Main while
	public final void play() throws InterruptedException {
		Map map = this.model.getMap();
		while (true) {
			map = this.model.getMap();
			Thread.sleep(100);
			map.getOpponent().forEach((opponent) -> opponent.refreshOpponents());
			endOfGame();
			this.model.modelNotify();
		}
	}
	
	public void endOfGame() throws InterruptedException {
		if (this.model.getMap().getPlayer().isAlive() == false) {
			this.view.printMessage("Blurp !");
			System.exit(0);
		}
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
		this.model.loadMap(map);
		this.view.printMessage("Current level: " + map);
	}

}
