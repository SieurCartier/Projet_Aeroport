package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelFabric extends GenericFabric<Hotel> {

	private static HotelFabric singleton = null;

	public HotelFabric() {
		super("Hotel", "idHotel");
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

			ret = new Hotel(idHotel, name, reservationDayNumber, c);
			objects.put(ret.getId(), ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	@Override
	public void delete(Hotel h) {
		HotelRoomFabric.getInstanceOf().deleteAllRooms(h);
		super.delete(h);
	}

	public List<Hotel> getHotelsOf(City city) {
		List<Hotel> ret = null;
		try {
			ret = new LinkedList<Hotel>();
			String requete = "SELECT * " + "FROM Hotel " + "WHERE fk_idVille = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, city.getId());
			ResultSet hotels = pr.executeQuery();

			while (hotels.next()) {
				Hotel temp = new Hotel(hotels.getInt("idHotel"), hotels.getString("Name"),
						hotels.getInt("ResiliationDayNumber"), city);
				if (!objects.containsKey(temp.getId()))
					objects.put(temp.getId(), temp);
				ret.add(temp);
			}
			pr.close();
			hotels.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	@Override
	public void SQLquerryById(int id) {
		try {
			String requete = "SELECT * " + "FROM Hotel " + "WHERE idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, id);
			ResultSet hotel = pr.executeQuery();

			if (hotel.next()) {
				objects.put(hotel.getInt("idHotel"), new Hotel(hotel.getInt("idHotel"), hotel.getString("Name"),
						hotel.getInt("ResiliationDayNumber"), hotel.getInt("idCity")));
			}
			pr.close();
			hotel.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
