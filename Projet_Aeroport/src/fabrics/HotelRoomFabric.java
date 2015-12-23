package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

/**
 * This class is a <code>Fabric</code> of {@link HotelRoom}
 * 
 * @author Gaston Lemaire
 */
public class HotelRoomFabric extends AbstractFabric<HotelRoom> {

	private static HotelRoomFabric singleton = null;

	private HotelRoomFabric() {
		super("HotelRoom", "idHotelRoom");
	}

	public static HotelRoomFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelRoomFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected HotelRoom constructObject(ResultSet rooms) throws SQLException {
		return new HotelRoom(rooms.getInt("idHotelRoom"), rooms.getString("roomNumber"), rooms.getInt("idCategory"),
				rooms.getInt("idHotel"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected HotelRoom constructObject(int id, HashMap<String, Object> m) {
		return new HotelRoom(id, (String) m.get("roomNumber"), (int) m.get("fk_idCategorie"),
				(int) m.get("fk_idHotel"));
	}

	/**
	 * This method creates a {@link HotelRoom}.
	 * 
	 * @param roomNumber
	 *            The room number of the {@link HotelRoom}.
	 * @param category
	 *            The {@link Category} of the {@link HotelRoom}.
	 * @param ownerHotel
	 *            The {@link Hotel} of the {@link HotelRoom}.
	 * @return The new {@link Customer}.
	 */
	public HotelRoom createHotelRoom(String roomNumber, Category category, Hotel ownerHotel) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fk_idCategorie", category.getId());
		parameters.put("fk_idHotel", ownerHotel.getId());
		parameters.put("roomNumber", roomNumber);

		return super.create(parameters);
	}

	/**
	 * This method gets the {@link List} of {@link HotelRoom} of a {@link Hotel}
	 * .
	 * 
	 * @param hotel
	 *            The {@link Hotel}.
	 * @return A {@link List} of {@link HotelRoom}.
	 */
	public List<HotelRoom> getRoomsOf(Hotel hotel) {
		return super.getFromForeignKey("fk_idHotel", hotel);
	}

	/**
	 * This method deletes every {@link HotelRoom} of a {@link Hotel}.
	 * 
	 * @param h
	 *            The {@link Hotel}.
	 */
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

}
