package ihm;

import domain.Reservation;
import fabrics.ReservationFabric;
import job.AbstractJob;
import job.ReservationJob;

public class SearchReservationWindow extends AbstractWindow<ReservationJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Reservation, ReservationFabric> getJob() {
		return new ReservationJob();
	}

}
