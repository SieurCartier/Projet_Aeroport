package ihm;

import domain.Flight;
import fabrics.FlightFabric;
import job.AbstractJob;
import job.FlightJob;

public class SearchFlightWindow extends AbstractWindow<FlightJob> {

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

}
