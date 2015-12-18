package fabrics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import domaine.City;

public class CityFabric extends GenericFabric<City> {

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
	public void SQLquerryById(int id) {
		try {
			String requete = "SELECT * " + "FROM City " + "WHERE idVille = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, id);
			ResultSet city = pr.executeQuery();

			if (city.next()) {
				City temp = new City(city.getInt("idVille"), city.getString("name"));
				objects.put(id, temp);
			}
			pr.close();
			city.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
