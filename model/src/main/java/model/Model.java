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
	public Model() {
		this.map = new Map();
	}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	private void setMap(final Map map) {
		this.map = map;
		this.modelNotify();
	}

	/**
	 * Load map.
	 *
	 * @param id the id
	 */
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
	public void modelNotify() {
        setChanged();
        notifyObservers();
    }
}
