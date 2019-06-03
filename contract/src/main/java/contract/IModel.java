package contract;

import java.sql.SQLException;
import java.util.Observable;

import element.Map;

/**
 * The Interface IModel.
 *
 * @author Jean michel crapaud The class IModel Saved as file IModel.java
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
	 * @param i the code
	 * @throws Exception exception
	 * @throws SQLException SQLException
	 */
	void loadMap(int i) throws SQLException, Exception;

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
