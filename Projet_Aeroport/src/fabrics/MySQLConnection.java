package fabrics;

import java.sql.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * This class provides a unique {@link Connection} to a MySQL Database to every
 * other classes of the application. In order to use it properly, you must call
 * {@link #setUp(String, String, String, String)} before using it.
 * 
 * @author Gaston Lemaire
 * 
 */
public class MySQLConnection {

	private static MySQLConnection singleton;
	private static Connection conn;

	private MySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static MySQLConnection getInstanceOf() {
		if (singleton == null) {
			singleton = new MySQLConnection();
		}
		return singleton;
	}

	/**
	 * This method needs to be called before every other methods. It sets up the
	 * {@link MySQLConnection} for everyone.
	 * 
	 * @param host
	 *            The address of the DBHost.
	 * @param DBName
	 *            The name of th DB.
	 * @param user
	 *            The id of the user for the {@link MySQLConnection}.
	 * @param password
	 *            The password of the user for the {@link MySQLConnection}.
	 */
	public void setUp(String host, String DBName, String user, String password) {
		try {

			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser(user);
			dataSource.setPassword(password);
			dataSource.setServerName(host);
			dataSource.setDatabaseName(DBName);

			conn = dataSource.getConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Connection#prepareStatement(String)
	 */
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.Connection#prepareStatement(String, int)
	 */
	public PreparedStatement prepareStatement(String sql,
			int returnGeneratedKeys) throws SQLException {
		return conn.prepareStatement(sql, returnGeneratedKeys);
	}
}