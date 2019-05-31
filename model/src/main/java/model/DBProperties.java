package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class DBProperties.
 *
 * @author Jean michel crapaud
 * The class DBProperties
 * Saved as file DBProperties.java
 */
class DBProperties extends Properties {

	/** The Constant serialVersionUID. */
	private static final long		serialVersionUID			= 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/** The url. */
	private String url = "";

	/** The login. */
	private String login = "";

	/** The password. */
	private String password	= "";

	/**
	 * Instantiates a new DB properties.
	 */
	// DBProperties constructor
	public DBProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);
		// Set the database connection properties
		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			// Set the database connection url
			this.setUrl(this.getProperty("url"));
			// Set the database connection login
			this.setLogin(this.getProperty("login"));
			// Set the database connection password
			this.setPassword(this.getProperty("password"));
		}
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	// Get the database connection url
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *          the new url
	 */
	// Set the database connection url
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	// Get the database connection login
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login
	 *          the new login
	 */
	// Set the database connection login
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	// Get the database connection password
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *          the new password
	 */
	// Set the database connection password
	private void setPassword(final String password) {
		this.password = password;
	}

}
