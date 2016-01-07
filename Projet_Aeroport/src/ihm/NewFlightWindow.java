package ihm;

import domain.Flight;
import fabrics.FlightFabric;
import job.AbstractJob;
import job.FlightJob;

public class NewFlightWindow extends AbstractNewDatabaseItemWindow<Flight, FlightJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Flight, FlightFabric> getJob() {
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
