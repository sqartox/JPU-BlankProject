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
	 * Instantiates a new DAO Map.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	// DAOMap constructor
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	// GEt the database connection
	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the map
	 * @throws Exception exception
	 */
	// Find Map in database using ID
	public Map find(final int id) throws Exception {
		try {
			// Call the 'mapById' SQL procedure in MySQL
			final String sql = "{call mapById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			// Get the call result
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				// Create a new Map
				return new Map(id, resultSet.getString("level"));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
