package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import element.Element;
import element.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}

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

	@Override
	public Element getMobileByPlayer(final int player) {
		for (int y = 0; y < this.getMap().getHeight(); y++) {
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				if (this.getMap().getMapObjects(x, y).isPlayer(player) == true) {
					return this.getMap().getMapObjects(x, y);
				}
			}
		}
		return null;
	}

	public Observable getObservable() {
		return this;
	}
	
	public void modelNotify() {
        setChanged();
        notifyObservers();
    }
}
