package fabrics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import domaine.City;
import domaine.Hotel;
import utils.InexistantHotelException;
import utils.NotCreatedHotelException;

public class HotelFabric {

	private static HotelFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private HashMap<Integer, Hotel> lesHotels = new HashMap<Integer, Hotel>();

	private HotelFabric() {

	}

	public static HotelFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelFabric();
		return singleton;
	}

	public Hotel createHotel() {

		Hotel ret = null;

		try {
			String requete = "INSERT INTO Hotel " + "VALUES (?, ?, ?, ?, ?)";

			int idHotel;
			PreparedStatement pr = co.prepareStatement(requete);
			/*
			 * pr.setString(1, nom); pr.setString(2, prenom); pr.setString(3,
			 * nom); pr.setString(4, prenom); pr.setString(5, nom);
			 */

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedHotelException();

			idHotel = newIdResult.getInt(1);

			ret = new Hotel();
			lesHotels.put(idHotel, ret);
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
			/*
			 * pr.setInt(1, p.getId());
			 */
			int err = pr.executeUpdate();

			if (err != 1) {
				throw new InexistantHotelException();
			}
			lesHotels.remove(h);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Hotel> getHotelsOf(City city) {
		return null;
	}

}
