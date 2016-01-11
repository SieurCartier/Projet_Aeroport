package job;

import java.util.HashMap;
import domain.*;
import fabrics.ReservationFabric;

public class ReservationJob extends AbstractJob<Reservation, ReservationFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Reservation create(HashMap<String, Object> fields) {
		Reservation ret = null;
		try {
			Customer customer = (Customer) fields.get("customer");
			Flight flight = (Flight) fields.get("flight");
			HotelRoom room = (HotelRoom) fields.get("room");

			ret = fab.createReservation(customer, flight, room);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected ReservationFabric getFabric() {
		return ReservationFabric.getInstanceOf();
	}

}
