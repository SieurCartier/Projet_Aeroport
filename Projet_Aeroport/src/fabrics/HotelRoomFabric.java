package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelRoomFabric {

	private static HotelRoomFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private HashMap<Hotel, HashMap<Integer, HotelRoom>> lesChambres = new HashMap<Hotel, HashMap<Integer, HotelRoom>>();

	private HotelRoomFabric() {

	}

	public static HotelRoomFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelRoomFabric();
		return singleton;
	}

	public HotelRoom createHotelRoom(Hotel h) {
		HotelRoom ret = null;

		try {
			String requete = "INSERT INTO HotelRooms " + "VALUES (?, ?, ?, ?, ?)";

			int idHotelRoom;
			PreparedStatement pr = co.prepareStatement(requete);
			/*
			 * pr.setString(1, nom); pr.setString(2, prenom); pr.setString(3,
			 * nom); pr.setString(4, prenom); pr.setString(5, nom);
			 */
			pr.setInt(5, h.getId());

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedHotelException();

			idHotelRoom = newIdResult.getInt(1);

			ret = new HotelRoom();
			lesChambres.get(h).put(idHotelRoom, ret);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void deleteHotelRoom(HotelRoom h) {
		try {
			String requete = "DELETE FROM HotelRoom WHERE idRoom =?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, h.getId());

			if (pr.executeUpdate() != 1)
				throw new InexistantHotelRoomException();

			lesChambres.get(h.getHotel()).remove(h);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteAllRooms(Hotel h) {
		try {
			String requete = "DELETE FROM HotelRoom WHERE idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setInt(1, h.getId());

			lesChambres.put(h, new HashMap<Integer, HotelRoom>());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
