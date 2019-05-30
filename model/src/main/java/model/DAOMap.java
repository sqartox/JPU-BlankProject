package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import element.Map;


/**
 * The Class DAOMap.
 *
 * @author Jean michel crapaud
 * DAOMap
 * DAOMap.java
 * @param <M> the generic type
 */
class DAOMap<M extends Map> {

	/** The connection. */
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
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the map
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	public Map find(final int id) {

		try {
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				return new Map(id, resultSet.getString("level"));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
