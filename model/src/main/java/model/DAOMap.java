package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import element.Map;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */

class DAOMap<M extends Map> {

	private Connection connection;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}

	
	public boolean create(final Map map) {
		// Not implemented
		return false;
	}

	public boolean delete(final Map map) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	public boolean update(final Map map) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	public Map find(final int id) {
		Map map = new Map();

		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(id, resultSet.getString("level"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
