import fabrics.*;
import ihm.MainWindow;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		MySQLConnection conn = MySQLConnection.getInstanceOf();
		conn.setUp("webtp.fil.univ-lille1.fr", "routierp", "routierp", "az78qs45");
		//conn.setUp("localhost", "aeroport", "gaston", "gaston");

		CategoryFabric category = CategoryFabric.getInstanceOf();
		CityFabric city = CityFabric.getInstanceOf();
		CustomerFabric customer = CustomerFabric.getInstanceOf();
		FlightFabric.getInstanceOf();
		HotelFabric.getInstanceOf();
		HotelRoomFabric.getInstanceOf();
		ReservationFabric.getInstanceOf();

		new MainWindow().setVisible(true);

		/*
		 * City c = CityFabric.getInstanceOf().createCity("Nieppe"); Hotel h =
		 * HotelFabric.getInstanceOf().createHotel(c, "Ascotel", 12); Category
		 * cat = CategoryFabric.getInstanceOf().createCategory("normale", 2,
		 * 100, h); HotelRoom hr =
		 * HotelRoomFabric.getInstanceOf().createHotelRoom("B604", cat, h);
		 * Customer cus =
		 * CustomerFabric.getInstanceOf().createCustomer("gaston", "lemaire",
		 * new Date(), c);
		 * 
		 * System.out.println(c); System.out.println(h);
		 * System.out.println(cat); System.out.println(hr);
		 * System.out.println(cus);
		 * 
		 * c.setName("Armenti�res"); h.setName("Hilton");
		 * 
		 * CityFabric.getInstanceOf().updateCity(c);
		 * HotelFabric.getInstanceOf().updateHotel(h);
		 */
	}
}
