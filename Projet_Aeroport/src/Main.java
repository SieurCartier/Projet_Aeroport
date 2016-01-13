import fabrics.*;
import ihm.MainWindow;

public class Main {

	public static void main(String[] args) {

		MySQLConnection conn = MySQLConnection.getInstanceOf();
		conn.setUp("webtp.fil.univ-lille1.fr", "routierp", "routierp", "az78qs45");
		// conn.setUp("localhost", "aeroport", "gaston", "gaston");

		CategoryFabric.getInstanceOf();
		CityFabric.getInstanceOf();
		CustomerFabric.getInstanceOf();
		FlightFabric.getInstanceOf();
		HotelFabric.getInstanceOf();
		HotelRoomFabric.getInstanceOf();
		ReservationFabric.getInstanceOf();

		new MainWindow().setVisible(true);

	}
}
