package contract;

/**
 * The Interface IController.
 *
 * @author Jean michel crapaud
 * The class IController
 * Saved as file IController.java
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 * @throws Exception exception
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws Exception;
}
