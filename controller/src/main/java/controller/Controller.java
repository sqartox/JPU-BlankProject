package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import element.Direction;
import element.Element;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

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
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Map1:
				this.model.loadMap(1);
				break;
			case Map2:
				this.model.loadMap(2);
				break;
			case Map3:
				this.model.loadMap(3);
				break;
			case Map4:
				this.model.loadMap(4);
				break;
			case Map5:
				this.model.loadMap(5);
				break;
			case Map6:
				this.model.loadMap(6);
				break;
			case NOTHING:
				break;
			case UP:
				this.model.getMap().getPlayer().movePlayer("UP");
				this.model.modelNotify();
				break;
			case DOWN:
				this.model.getMap().getPlayer().movePlayer("DOWN");
				this.model.modelNotify();
				break;
			case LEFT:
				this.model.getMap().getPlayer().movePlayer("LEFT");
				this.model.modelNotify();
				break;
			case RIGHT:
				this.model.getMap().getPlayer().movePlayer("RIGHT");
				this.model.modelNotify();
				break;
		}
	}

	/*
	 * public final void play() throws InterruptedException { while
	 * (this.getModel().getMyVehicle().isAlive()) { Thread.sleep(speed); switch
	 * (this.getStackOrder()) { case RIGHT:
	 * this.getModel().getMyVehicle().moveRight(); break; case LEFT:
	 * this.getModel().getMyVehicle().moveLeft(); break; case NOP: default:
	 * this.getModel().getMyVehicle().doNothing(); break; } this.clearStackOrder();
	 * if (this.getModel().getMyVehicle().isAlive()) {
	 * this.getModel().getMyVehicle().moveDown(); }
	 * this.getView().followMyVehicle(); }
	 * this.getView().displayMessage("CRASH !!!!!!!!!."); }
	 */

}
