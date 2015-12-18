package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelFabric extends AbstractFabric<Hotel> {

	private static HotelFabric singleton = null;

	private WeakHashMap<City, List<Hotel>> lesHotels = new WeakHashMap<City, List<Hotel>>();

	public HotelFabric() {
		super("Hotel", "idHotel");
	}

	public static HotelFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelFabric();
		return singleton;
	}

	@Override
	protected Hotel constructObject(ResultSet hotel) throws SQLException {
		return new Hotel(hotel.getInt("idHotel"), hotel.getString("Name"), hotel.getInt("ResiliationDayNumber"),
				hotel.getInt("idCity"));
	}

	@Override
	public void delete(Hotel h) {
		HotelRoomFabric.getInstanceOf().deleteAllRooms(h);
		super.delete(h);
	}

	@Override
	protected void addItem(Hotel h) {
		super.addItem(h);
		if (!lesHotels.containsKey(h.getCity()))
			lesHotels.put(h.getCity(), new LinkedList<Hotel>());

		lesHotels.get(h.getCity()).add(h);
	}

	@Override
	protected void removeItem(Hotel h) {
		super.removeItem(h);
		if (lesHotels.containsKey(h.getCity()))
			lesHotels.get(h.getCity()).remove(h);
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

			ret = new Hotel(idHotel, name, reservationDayNumber, c);
			addItem(ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public List<Hotel> getHotelsOf(City city) {
		if (!lesHotels.containsKey(city)) {
			try {
				String requete = "SELECT * " + "FROM Hotel " + "WHERE fk_idVille = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, city.getId());
				ResultSet hotels = pr.executeQuery();

				while (hotels.next()) {
					addItem(constructObject(hotels));
				}
				pr.close();
				hotels.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return lesHotels.get(city);
	}

}
