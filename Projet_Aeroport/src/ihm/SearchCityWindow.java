package ihm;

import domain.City;
import fabrics.CityFabric;
import job.AbstractJob;
import job.CityJob;

public class SearchCityWindow extends AbstractWindow<CityJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<City, CityFabric> getJob() {
		return new CityJob();
	}

}
