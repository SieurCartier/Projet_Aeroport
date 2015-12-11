package fabrics;

import java.util.HashMap;
import domaine.City;
import domaine.Hotel;

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

	public City getCityById(int idCity) {
		// TODO Auto-generated method stub
		return null;
	}

}
