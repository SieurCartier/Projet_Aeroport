package fabrics;

import java.sql.*;

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

	public void setUp(String DBName, String user, String password) {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://webtp.fil.univ-lille1.fr/" + DBName + "?username=" + user + "&password=" + password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

}