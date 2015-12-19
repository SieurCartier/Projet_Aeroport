import java.util.Date;

import domaine.*;
import fabrics.*;

public class Main {

	public static void main(String[] args) {

		MySQLConnection conn = MySQLConnection.getInstanceOf();
		// conn.setUp("webtp.fil.univ-lille1.fr","", "", "");
		conn.setUp("localhost", "aeroport", "gaston", "gaston");

		City c = CityFabric.getInstanceOf().createCity("Nieppe");
		Hotel h = HotelFabric.getInstanceOf().createHotel(c, "Ascotel", 12);
		Category cat = CategoryFabric.getInstanceOf().createCategory("normale", 2, 100, h);
		HotelRoom hr = HotelRoomFabric.getInstanceOf().createHotelRoom("B604", cat, h);
		Customer cus = CustomerFabric.getInstanceOf().createCustomer("gaston", "lemaire", new Date(), c);

		System.out.println(c);
		System.out.println(h);
		System.out.println(cat);
		System.out.println(hr);
		System.out.println(cus);

	}
}
