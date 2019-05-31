package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Jean michel crapaud
 * The class DBConnection
 * Saved as file DBConnection.java
 */
final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;

	/**
	 * Instantiates a new DB connection.
	 */
	// DBConnection constructor
	private DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	// Get the unique instance of DBConnection
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			// Create a new DBConnection Instance
			DBConnection.INSTANCE = new DBConnection();
		}
		// Return the new DBConnection Instance
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	// Open a DBConnection
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			// Get the JDBC drivers
			Class.forName("com.mysql.jdbc.Driver");
			// Open the connection
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	// Get the DBConnection
	public Connection getConnection() {
		return this.connection;
	}
}
