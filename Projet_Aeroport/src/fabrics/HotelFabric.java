package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;

public class HotelFabric extends AbstractFabric<Hotel> {

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
	protected Hotel constructObject(int id, HashMap<String, Object> m) {
		return new Hotel(id, (String) m.get("name"), (int) m.get("resilationDayNumber"), (int) m.get("fk_idCity"));
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

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("resilationDayNumber", reservationDayNumber);
		parameters.put("fk_idCity", c.getId());

		return super.create(parameters);
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
