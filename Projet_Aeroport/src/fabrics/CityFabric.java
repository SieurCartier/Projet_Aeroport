package fabrics;

import java.util.HashMap;
import java.util.List;

import domaine.Category;
import domaine.City;
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

	public City getCity(int id) {
		return null;
	}

}
