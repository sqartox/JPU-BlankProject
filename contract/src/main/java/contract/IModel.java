package contract;

import java.util.Observable;

import entity.Map;

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
	//HelloWorld getHelloWorld();
	
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
}
