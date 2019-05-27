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
		this.setMap(1);
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
		this.view.printMessage("Choose Map : NUMPAD 1 - 5");
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
			this.model.loadMap(map);
			this.orderPerform(ControllerOrder.NOTHING);
			break;
		case Map2:
			this.model.loadMap(map + 1);
			this.orderPerform(ControllerOrder.NOTHING);
			break;
		case Map3:
			this.model.loadMap(map + 2);
			this.orderPerform(ControllerOrder.NOTHING);
			break;
		case Map4:
			this.model.loadMap(map + 3);
			this.orderPerform(ControllerOrder.NOTHING);
			break;
		case Map5:
			this.model.loadMap(map + 4);
			this.orderPerform(ControllerOrder.NOTHING);
			break;
		case NOTHING:
			this.model.getMap().getPlayer().setDirection(Direction.NOTHING);
			break;
		case UP:
			if (changeMap(0, -1)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
				this.orderPerform(ControllerOrder.NOTHING);
			}
			this.model.getMap().getPlayer().setDirection(Direction.UP);
			break;
		case DOWN:
			if (changeMap(0, +1)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
				this.orderPerform(ControllerOrder.NOTHING);
			}
			this.model.getMap().getPlayer().setDirection(Direction.DOWN);
			break;
		case LEFT:
			if (changeMap(-1, 0)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
				this.orderPerform(ControllerOrder.NOTHING);
			}
			this.model.getMap().getPlayer().setDirection(Direction.LEFT);
			break;
		case RIGHT:
			if (changeMap(+1, 0)) {
				this.setMap(this.getMap()+1);
				this.model.loadMap(map);
				this.orderPerform(ControllerOrder.NOTHING);
			}
			this.model.getMap().getPlayer().setDirection(Direction.RIGHT);
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
		while (map.getPlayer().isAlive()) {
			map = this.model.getMap();
			Thread.sleep(10);
			switch (map.getPlayer().getDirection()) {
			case RIGHT:
				map.getPlayer().movePlayer(Direction.RIGHT);
				this.model.modelNotify();
				break;
			case LEFT:
				map.getPlayer().movePlayer(Direction.LEFT);
				this.model.modelNotify();
				break;
			case UP:
				map.getPlayer().movePlayer(Direction.UP);
				this.model.modelNotify();
				break;
			case DOWN:
				map.getPlayer().movePlayer(Direction.DOWN);
				this.model.modelNotify();
				break;
			case NOTHING:
				break;
			}

	        this.orderPerform(ControllerOrder.NOTHING);
		}
		this.view.printMessage("Blurp !");
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

}
