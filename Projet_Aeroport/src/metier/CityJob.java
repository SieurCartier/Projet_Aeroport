package metier;

import java.util.HashMap;

import domaine.City;
import fabrics.CityFabric;

/*
 * This class will take care of the third use case : "Gestion de la liste des villes"
 */
public class CityJob extends AbstractJob<City, CityFabric> {

	public CityJob() {
		fab = CityFabric.getInstanceOf();
	}

	@Override
	public City create(HashMap<String, String> fields) {
		String name = fields.get("name");
		return fab.createCity(name);
	}

	@Override
	public void remove(City t) {
		fab.delete(t);
	}

}
