package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import element.Map;

/**
 * The Class Model.
 *
 * @author Jean michel crapaud
 * The class Model
 * Saved as file Model.java
 */
public final class Model extends Observable implements IModel {
	
	/** The map. */
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	// Model constructor
	public Model() {
		// Create a new game Map
		this.map = new Map();
	}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	// Get the Map
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	// Set the game Map
	private void setMap(final Map map) {
		// Refresh graphics
		this.map = map;
		// Refresh graphics
		this.modelNotify();
	}

	/**
	 * Load map.
	 *
	 * @param id the id
	 */
	// Load a game Map
	@Override
	public void loadMap(int id) {
		try {
			this.setMap(new DAOMap<Map>(DBConnection.getInstance().getConnection()).find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Model notify.
	 */

	// Refresh graphics
	public void modelNotify() {
		// Set changes
        setChanged();
    	// notify changes to the Model
        notifyObservers();
    }
}
