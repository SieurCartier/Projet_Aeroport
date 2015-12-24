package ihm;

import domain.Reservation;
import fabrics.ReservationFabric;
import job.AbstractJob;
import job.ReservationJob;

public class NewReservationWindow extends AbstractNewDatabaseItemWindow<Reservation, ReservationJob> {

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
