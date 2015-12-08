import fabrics.MySQLConnection;

public class Main {

	public static void main(String[] args) {

		MySQLConnection conn = MySQLConnection.getInstanceOf();
		//conn.setUp("webtp.fil.univ-lille1.fr","", "", "");
		conn.setUp("localhost","aeroport", "gaston", "gaston");
		

	}

}
