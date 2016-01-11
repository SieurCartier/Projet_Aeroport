package ihm;

import domain.City;
import job.CityJob;

public class SearchCityWindow extends AbstractWindow<City> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected CityJob getJob() {
		return new CityJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#build()
	 */
	@Override
	protected void build() {
		// TODO Auto-generated method stub

	}

}
