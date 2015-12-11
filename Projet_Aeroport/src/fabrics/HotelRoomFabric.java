package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelRoomFabric {

	private static HotelRoomFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private WeakHashMap<Hotel, List<HotelRoom>> lesChambres = new WeakHashMap<Hotel, List<HotelRoom>>();

	private HotelRoomFabric() {

	}

	public static HotelRoomFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelRoomFabric();
		return singleton;
	}

	public HotelRoom createHotelRoom(String roomNumber, int idCategory, int idOwnerHotel) {
		HotelRoom ret = null;

		try {
			String requete = "INSERT INTO HotelRooms " + "VALUES (?, ?, ?)";

			int idHotelRoom;
			PreparedStatement pr = co.prepareStatement(requete);

			pr.setString(1, roomNumber);
			pr.setInt(2, idCategory);
			pr.setInt(3, idOwnerHotel);

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedHotelRoomException();

			idHotelRoom = newIdResult.getInt(1);

			ret = new HotelRoom(idHotelRoom, roomNumber, idCategory, idOwnerHotel);
			lesChambres.get(HotelFabric.getInstanceOf().getHotelById(idOwnerHotel)).add(ret);
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

			lesChambres.put(h, new LinkedList<HotelRoom>());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<HotelRoom> getRoomsOf(Hotel hotel) {
		if (!lesChambres.containsKey(hotel)) {
			lesChambres.put(hotel, new LinkedList<HotelRoom>());
			try {
				String requete = "SELECT * " + "FROM HotelRoom " + "WHERE fk_idHotel = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, hotel.getId());
				ResultSet rooms = pr.executeQuery();

				while (rooms.next()) {
					lesChambres.get(hotel).add(new HotelRoom(rooms.getInt("idHotelRoom"), rooms.getString("roomNumber"),
							rooms.getInt("idCategory"), rooms.getInt("idHotel")));
				}
				pr.close();
				rooms.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return lesChambres.get(hotel);
	}

	public HotelRoom getHotelRoomById(int idFlight) {
		// TODO Auto-generated method stub
		return null;
	}

}
