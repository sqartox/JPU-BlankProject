package contract;

import java.util.Observable;

import element.Element;
import element.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	Map getMap();

	/**
	 * Load the message.
	 *
	 * @param i
	 *          the code
	 */
	//void loadHelloWorld(String code);
	
	void loadMap(int i);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	Element getMobileByPlayer(int player);
}
