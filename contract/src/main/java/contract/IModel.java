package contract;

import java.util.Observable;

import element.Map;

/**
 * @author Jean michel crapaud
 * The class IModel
 * Saved as file IModel.java
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

	void modelNotify();

}
