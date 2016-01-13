package fabrics;

import java.sql.*;
import java.util.*;

import domain.City;

/**
 * This class is a <code>Fabric</code> of {@link City}
 * 
 * @author Gaston Lemaire
 */
public class CityFabric extends AbstractFabric<City> {

	private static CityFabric singleton = null;

	public CityFabric() {
		super("city", "idCity");
	}

	public static CityFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CityFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected City constructObject(ResultSet city) throws SQLException {
		return new City(city.getInt("idCity"), city.getString("name"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected City constructObject(int id, HashMap<String, Object> m) {
		return new City(id, (String) m.get("name"));
	}

	/**
	 * This method creates a {@link City}.
	 * 
	 * @param name
	 *            The name of the {@link City}.
	 * @return The new {@link City}.
	 */
	public City createCity(String name) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);

		return super.create(parameters);
	}

	/**
	 * This method updates a {@link City}.
	 * 
	 * @param c
	 *            The {@link City} to update.
	 */
	public void updateCity(City c) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", c.getName());

		super.update(c, parameters);
	}

	public List<City> getByName(String name) {
		List<City> ret = null;
		Set<City> temp = new HashSet<City>();

		for (City c : objects.values()) {
			if (c.getName().equals(name)) {
				temp.add(c);
			}
		}

		temp.addAll(super.getFromField("name", name));

		if (!temp.isEmpty()) {
			ret = new ArrayList<>();
			ret.addAll(temp);
		}

		return ret;
	}

}
