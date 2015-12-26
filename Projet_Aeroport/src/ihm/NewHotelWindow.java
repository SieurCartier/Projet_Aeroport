package ihm;

import domain.Hotel;
import fabrics.HotelFabric;
import job.AbstractJob;
import job.HotelJob;

public class NewHotelWindow extends
		AbstractNewDatabaseItemWindow<Hotel, HotelJob> {

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
	 * @see ihm.AbstractNewDatabaseItemWindow#initComponents()
	 */
	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub

	}

}
