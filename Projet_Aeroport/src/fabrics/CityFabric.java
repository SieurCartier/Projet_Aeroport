package fabrics;

import java.util.HashMap;
import java.util.List;

import domaine.Category;
import domaine.Hotel;
import domaine.HotelRoom;

public class CityFabric {
	private static CityFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private HashMap<Integer, Hotel> lesVilles = new HashMap<Integer, Hotel>();

	private CityFabric() {

	}

	public static CityFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CityFabric();
		return singleton;
	}

	public List<HotelRoom> getRoomsOf(Hotel h) {
		return null;
	}

	public List<Category> getCategoriesOf(Hotel h) {
		return null;
	}
}
