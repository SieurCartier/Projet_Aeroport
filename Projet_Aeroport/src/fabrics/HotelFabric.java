package fabrics;

import java.sql.*;
import java.util.*;

import domain.*;

/**
 * This class is a <code>Fabric</code> of {@link Hotel}
 * 
 * @author Gaston Lemaire
 */
public class HotelFabric extends AbstractFabric<Hotel> {

	private static HotelFabric singleton = null;

	public HotelFabric() {
		super("hotel", "idHotel");
	}

	public static HotelFabric getInstanceOf() {
		if (singleton == null)
			singleton = new HotelFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected Hotel constructObject(ResultSet hotel) throws SQLException {
		return new Hotel(hotel.getInt("idHotel"), hotel.getString("Name"),
				hotel.getInt("ResiliationDayNumber"), hotel.getInt("idCity"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected Hotel constructObject(int id, HashMap<String, Object> m) {
		return new Hotel(id, (String) m.get("name"),
				(int) m.get("resilationDayNumber"), (int) m.get("fk_idCity"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#delete(domaine.DatabaseItem)
	 */
	@Override
	public void delete(Hotel h) {
		HotelRoomFabric.getInstanceOf().deleteAllRooms(h);
		super.delete(h);
	}

	/**
	 * This method creates a {@link Hotel}.
	 * 
	 * @param c
	 *            The {@link City} of the {@link Hotel}.
	 * @param name
	 *            The name of the {@link Hotel}.
	 * @param reservationDayNumber
	 *            The number of days of the period before the
	 *            {@link Reservation} in which you can't cancel it.
	 * @return The new {@link Customer}.
	 */
	public Hotel createHotel(City c, String name, int reservationDayNumber) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("resilationDayNumber", reservationDayNumber);
		parameters.put("fk_idCity", c.getId());

		return super.create(parameters);
	}

	/**
	 * This method updates a {@link Hotel}.
	 * 
	 * @param h
	 *            The {@link Hotel} to update.
	 */
	public void updateHotel(Hotel h) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", h.getName());
		parameters.put("resilationDayNumber", h.getReservationDayNumber());
		parameters.put("fk_idCity", h.getCity().getId());

		super.update(h, parameters);
	}

	/**
	 * This method gets the {@link List} of {@link Hotel} of a {@link City}.
	 * 
	 * @param city
	 *            The {@link City}.
	 * @return A {@link List} of {@link Hotel}.
	 */
	public List<Hotel> getHotelsOf(City city) {
		return super.getFromForeignKey("fk_idVille", city);
	}

}
