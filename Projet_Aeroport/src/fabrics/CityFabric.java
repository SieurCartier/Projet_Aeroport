package fabrics;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domaine.City;

public class CityFabric extends AbstractFabric<City> {

	private static final int NAME = 0;

	private static CityFabric singleton = null;

	public CityFabric() {
		super("City", "idVille");
	}

	public static CityFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CityFabric();
		return singleton;
	}

	@Override
	protected City constructObject(ResultSet city) throws SQLException {
		return new City(city.getInt("idVille"), city.getString("name"));
	}

	@Override
	protected City constructObject(int id, Object[] m) {
		return new City(id, (String) m[NAME]);
	}

	public City createCity(String name) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(name);

		String[] columns = { "name" };

		return CityFabric.getInstanceOf().create(columns, parameters.toArray());
	}

}
