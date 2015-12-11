package fabrics;

import java.util.WeakHashMap;

import domaine.City;
import domaine.Hotel;

public class CityFabric {
	private static CityFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private WeakHashMap<Integer, Hotel> lesVilles = new WeakHashMap<Integer, Hotel>();

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
