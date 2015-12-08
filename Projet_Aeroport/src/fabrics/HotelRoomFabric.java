package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelRoomFabric {

	private static HotelRoomFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private HashMap<Hotel, HashMap<String, HotelRoom>> lesChambres = new HashMap<Hotel, HashMap<String, HotelRoom>>();

	private HotelRoomFabric() {

	}

	public static HotelRoomFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelRoomFabric();
		return singleton;
	}

	public HotelRoom createHotelRoom(Hotel ownerHotel, String roomNumber, Category cat) {
		HotelRoom ret = null;

		try {
			String requete = "INSERT INTO HotelRooms " + "VALUES (?, ?, ?)";

			int idHotelRoom;
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setString(1, roomNumber);
			pr.setInt(2, cat.getId());
			pr.setInt(3, ownerHotel.getId());

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedHotelRoomException();

			idHotelRoom = newIdResult.getInt(1);

			ret = new HotelRoom(idHotelRoom, ownerHotel, roomNumber, cat);
			lesChambres.get(ownerHotel).put(roomNumber, ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void deleteHotelRoom(HotelRoom h) {
		try {
			String requete = "DELETE FROM HotelRoom WHERE idRoom = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, h.getId());

			if (pr.executeUpdate() != 1)
				throw new InexistantHotelRoomException();

			lesChambres.get(h.getOwnerHotel()).remove(h);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteAllRooms(Hotel h) {
		try {
			String requete = "DELETE FROM HotelRoom WHERE idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setInt(1, h.getId());

			lesChambres.put(h, new HashMap<String, HotelRoom>());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public HashMap<String, HotelRoom> getRoomsOf(Hotel hotel) {
		if (!lesChambres.containsKey(hotel)) {
			lesChambres.put(hotel, new HashMap<String, HotelRoom>());
			try {
				String requete = "SELECT * " + "FROM HotelRoom " + "WHERE fk_idHotel = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, hotel.getId());
				ResultSet rooms = pr.executeQuery();

				while (rooms.next()) {
					lesChambres.get(hotel).put(rooms.getString("roomNumber"), new HotelRoom(rooms.getInt("idHotelRoom"), rooms.getString("roomNumber"), rooms.getInt("ResiliationDayNumber")));

				}
				pr.close();
				rooms.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return lesChambres.get(hotel);
	}

}
