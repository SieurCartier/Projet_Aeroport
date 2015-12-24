package job;

import java.util.HashMap;

import domain.Reservation;
import fabrics.ReservationFabric;

public class ReservationJob extends AbstractJob<Reservation, ReservationFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Reservation create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#remove(domain.DatabaseItem)
	 */
	@Override
	public void remove(Reservation t) {
		// TODO Auto-generated method stub

	}

}
