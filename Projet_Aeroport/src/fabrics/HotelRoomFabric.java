package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelRoomFabric extends AbstractFabric<HotelRoom> {

	private enum ColumnNames {
		fk_idCategorie, fk_idHotel, roomNumber
	}

	private static final int FK_ID_CATEGORIE = ColumnNames.fk_idCategorie.ordinal();
	private static final int FK_ID_HOTEL = ColumnNames.fk_idHotel.ordinal();
	private static final int ROOM_NUMBER = ColumnNames.roomNumber.ordinal();

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
	protected HotelRoom constructObject(int id, Object[] m) {
		return new HotelRoom(id, (String) m[ROOM_NUMBER], (int) m[FK_ID_CATEGORIE], (int) m[FK_ID_HOTEL]);
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
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(category.getId());
		parameters.add(ownerHotel.getId());
		parameters.add(roomNumber);

		return super.create(Enums.toStringArray(ColumnNames.values()), parameters.toArray());
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
