package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import element.Map;

/**
 * @author Jean michel crapaud
 * The class Model
 * Saved as file Model.java
 */
public final class Model extends Observable implements IModel {
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

	private void setMap(final Map map) {
		this.map = map;
		this.modelNotify();
	}

	@Override
	public void loadMap(int id) {
		try {
			this.setMap(new DAOMap<Map>(DBConnection.getInstance().getConnection()).find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public Observable getObservable() {
		return this;
	}
	
	public void modelNotify() {
        setChanged();
        notifyObservers();
    }
}
