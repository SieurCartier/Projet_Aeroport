package job;

import java.util.*;
import domain.City;
import fabrics.CityFabric;

/**
 * This class will take care of the third use case :
 * "Gestion de la liste des villes"
 */
public class CityJob extends AbstractJob<City, CityFabric> {

	public CityJob() {
		fab = CityFabric.getInstanceOf();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public City create(HashMap<String, Object> fields) {
		String name = (String) fields.get("name");
		return fab.createCity(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected CityFabric getFabric() {
		return CityFabric.getInstanceOf();
	}

}
