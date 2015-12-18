package fabrics;

import java.sql.*;

import domaine.City;

public class CityFabric extends AbstractFabric<City> {

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

}
