package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.*;

public class HotelFabric extends AbstractFabric<Hotel> {

	private enum ColumnNames {
		name, resilationDayNumber, fk_idCity
	}

	private static final int NAME = ColumnNames.name.ordinal();
	private static final int RESIALIATION_DAY_NUMBER = ColumnNames.resilationDayNumber.ordinal();
	private static final int FK_ID_CITY = ColumnNames.fk_idCity.ordinal();

	private static HotelFabric singleton = null;

	private WeakHashMap<City, List<Hotel>> lesHotels = new WeakHashMap<City, List<Hotel>>();

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
	protected Hotel constructObject(int id, Object[] m) {
		return new Hotel(id, (String) m[NAME], (int) m[RESIALIATION_DAY_NUMBER], (int) m[FK_ID_CITY]);
	}

	@Override
	public void delete(Hotel h) {
		HotelRoomFabric.getInstanceOf().deleteAllRooms(h);
		super.delete(h);
	}

	@Override
	protected void addItem(Hotel h) {
		super.addItem(h);
		if (!lesHotels.containsKey(h.getCity()))
			lesHotels.put(h.getCity(), new LinkedList<Hotel>());

		lesHotels.get(h.getCity()).add(h);
	}

	@Override
	protected void removeItem(Hotel h) {
		super.removeItem(h);
		if (lesHotels.containsKey(h.getCity()))
			lesHotels.get(h.getCity()).remove(h);
	}

	public Hotel createHotel(City c, String name, int reservationDayNumber) {

		List<Object> parameters = new ArrayList<Object>();
		parameters.add(name);
		parameters.add(new Integer(reservationDayNumber));
		parameters.add(new Integer(c.getId()));

		return super.create(Enums.toStringArray(ColumnNames.values()), parameters.toArray());
	}

	public List<Hotel> getHotelsOf(City city) {
		if (!lesHotels.containsKey(city)) {
			try {
				String requete = "SELECT * " + "FROM Hotel " + "WHERE fk_idVille = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, city.getId());
				ResultSet hotels = pr.executeQuery();

				while (hotels.next()) {
					addItem(constructObject(hotels));
				}
				pr.close();
				hotels.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return lesHotels.get(city);
	}

}
