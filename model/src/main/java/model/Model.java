package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import element.Element;
import element.Map;
import mobileelement.MobileElement;

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
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void loadMap(int id) {
		try {
			final DAOMap<Map> daoMap = new DAOMap<Map>(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MobileElement getMobileByPlayer(final int player) {
		for (final Element[] mobile : this.getMap().getMapObjects())) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}

	public Observable getObservable() {
		return this;
	}
}
