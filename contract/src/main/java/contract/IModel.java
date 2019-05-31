package contract;

import java.util.Observable;

import element.Map;

/**
 * The Interface IModel.
 *
 * @author Jean michel crapaud
 * The class IModel
 * Saved as file IModel.java
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the map entity
	 */
	Map getMap();

	/**
	 * Load the Map.
	 *
	 * @param i
	 *          the code
	 */	
	void loadMap(int i);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * Model notify.
	 */
	void modelNotify();

}
