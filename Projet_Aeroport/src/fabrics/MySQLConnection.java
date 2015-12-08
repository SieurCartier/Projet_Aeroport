package fabrics;

import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

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

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

}