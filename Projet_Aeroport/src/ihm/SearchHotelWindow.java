package ihm;

import domain.Hotel;
import fabrics.HotelFabric;
import job.AbstractJob;
import job.HotelJob;

public class SearchHotelWindow extends AbstractWindow<HotelJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Hotel, HotelFabric> getJob() {
		return new HotelJob();
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
