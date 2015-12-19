package fabrics;

import java.sql.*;
import java.util.HashMap;

import domaine.City;

public class CityFabric extends AbstractFabric<City> {

	private static CityFabric singleton = null;

	public CityFabric() {
		super("City", "idCity");
	}

	public static CityFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CityFabric();
		return singleton;
	}

	@Override
	protected City constructObject(ResultSet city) throws SQLException {
		return new City(city.getInt("idCity"), city.getString("name"));
	}

	@Override
	protected City constructObject(int id, HashMap<String, Object> m) {
		return new City(id, (String) m.get("name"));
	}

	public City createCity(String name) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);

		return super.create(parameters);
	}

	public void updateCity(City c) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", c.getName());

		super.update(c, parameters);
	}

}
