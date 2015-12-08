package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelFabric {

	private static HotelFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private HashMap<Integer, Hotel> lesHotels = new HashMap<Integer, Hotel>();
	private WeakHashMap<City, List<Hotel>> hotelsByCity = new WeakHashMap<City, List<Hotel>>();

	private HotelFabric() {

	}

	public static HotelFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelFabric();
		return singleton;
	}

	public Hotel createHotel(City c, String name, int reservationDayNumber) {

		Hotel ret = null;

		try {
			String requete = "INSERT INTO Hotel " + "VALUES (?, ?, ?)";

			int idHotel;
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setInt(1, c.getId());
			pr.setString(2, name);
			pr.setInt(3, reservationDayNumber);

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedHotelException();

			idHotel = newIdResult.getInt(1);

			ret = new Hotel(idHotel, c, name, reservationDayNumber);
			addHotel(ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void deleteHotel(Hotel h) {
		try {
			HotelRoomFabric.getInstanceOf().deleteAllRooms(h);

			String requete = "DELETE FROM Hotel WHERE idHotel =?";
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setInt(1, h.getId());

			if (pr.executeUpdate() != 1)
				throw new InexistantHotelException();

			removeHotel(h);
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Hotel> getHotelsOf(City city) {
		if (!hotelsByCity.containsKey(city)) {
			try {
				String requete = "SELECT * " + "FROM Hotel " + "WHERE fk_idVille = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, city.getId());
				ResultSet hotels = pr.executeQuery();

				while (hotels.next()) {
					addHotel(new Hotel(hotels.getInt("idHotel"), city, hotels.getString("Name"),
							hotels.getInt("ResiliationDayNumber")));

				}
				pr.close();
				hotels.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		List<Hotel> ret = new LinkedList<Hotel>();
		for (Hotel h : lesHotels.values()) {
			if (h.getC().equals(city))
				ret.add(h);
		}

		return ret;
	}

	public List<Category> getCategoriesOf(Hotel hotel) {
		return null;
	}

	private void addHotel(Hotel h) {
		lesHotels.put(h.getId(), h);
		if (!hotelsByCity.containsKey(h.getC()))
			hotelsByCity.put(h.getC(), new LinkedList<Hotel>());
		hotelsByCity.get(h.getC()).add(h);
	}

	private void removeHotel(Hotel h) {
		lesHotels.remove(h);
		hotelsByCity.get(h.getC()).remove(h);
	}

}
