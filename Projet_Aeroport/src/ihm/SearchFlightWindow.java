package ihm;

import domain.Flight;
import job.FlightJob;

public class SearchFlightWindow extends AbstractWindow<Flight> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected FlightJob getJob() {
		return new FlightJob();
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
