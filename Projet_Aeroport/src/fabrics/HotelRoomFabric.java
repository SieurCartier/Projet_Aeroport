package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelRoomFabric extends AbstractFabric<HotelRoom> {

	private static HotelRoomFabric singleton = null;

	private WeakHashMap<Hotel, List<HotelRoom>> lesChambres = new WeakHashMap<Hotel, List<HotelRoom>>();

	private HotelRoomFabric() {
		super("HotelRoom", "idHotelRoom");
	}

	public static HotelRoomFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelRoomFabric();
		return singleton;
	}

	@Override
	protected HotelRoom constructObject(ResultSet rooms) throws SQLException {
		return new HotelRoom(rooms.getInt("idHotelRoom"), rooms.getString("roomNumber"), rooms.getInt("idCategory"),
				rooms.getInt("idHotel"));
	}

	@Override
	protected HotelRoom constructObject(int id, HashMap<String, Object> m) {
		return new HotelRoom(id, (String) m.get("roomNumber"), (int) m.get("fk_idCategorie"),
				(int) m.get("fk_idHotel"));
	}

	@Override
	protected void removeItem(HotelRoom h) {
		super.removeItem(h);
		if (lesChambres.containsKey(h.getOwnerHotel()))
			lesChambres.get(h.getOwnerHotel()).remove(h);
	}

	@Override
	protected void addItem(HotelRoom h) {
		super.addItem(h);
		if (!lesChambres.containsKey(h.getOwnerHotel()))
			lesChambres.put(h.getOwnerHotel(), new LinkedList<HotelRoom>());

		lesChambres.get(h.getOwnerHotel()).add(h);
	}

	public HotelRoom createHotelRoom(String roomNumber, Category category, Hotel ownerHotel) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fk_idCategorie", category.getId());
		parameters.put("fk_idHotel", ownerHotel.getId());
		parameters.put("roomNumber", roomNumber);

		return super.create(parameters);
	}

	public void deleteAllRooms(Hotel h) {
		try {
			String requete = "DELETE FROM HotelRoom WHERE fk_idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, h.getId());

			if (pr.executeUpdate() != 1)
				throw new InexistantDatabaseItemException(h);

			for (HotelRoom r : h.getRooms()) {
				removeItem(r);
			}
			pr.close();
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
					addItem(constructObject(rooms));
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
