package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;

public class HotelFabric extends AbstractFabric<Hotel> {

	private static HotelFabric singleton = null;

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
	protected Hotel constructObject(int id, HashMap<String, Object> m) {
		return new Hotel(id, (String) m.get("name"), (int) m.get("resilationDayNumber"), (int) m.get("fk_idCity"));
	}

	@Override
	public void delete(Hotel h) {
		HotelRoomFabric.getInstanceOf().deleteAllRooms(h);
		super.delete(h);
	}

	public Hotel createHotel(City c, String name, int reservationDayNumber) {

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("resilationDayNumber", reservationDayNumber);
		parameters.put("fk_idCity", c.getId());

		return super.create(parameters);
	}

	public List<Hotel> getHotelsOf(City city) {
		return super.getFromForeignKey("fk_idVille", city);
	}
}
