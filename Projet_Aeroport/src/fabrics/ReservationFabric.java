package fabrics;

import java.sql.*;
import java.util.*;

import domain.*;

/**
 * This class is a <code>Fabric</code> of {@link Reservation}
 * 
 * @author Gaston Lemaire
 */
public class ReservationFabric extends AbstractFabric<Reservation> {
	private static ReservationFabric singleton = null;

	public ReservationFabric() {
		super("reservation", "idReservation");
	}

	public static ReservationFabric getInstanceOf() {
		if (singleton == null)
			singleton = new ReservationFabric();
		return singleton;
	}

	/**
	 * This method gets the {@link List} of {@link Reservation} of a
	 * {@link Customer} .
	 * 
	 * @param c
	 *            The {@link Customer}.
	 * @return A {@link List} of {@link Customer}.
	 */
	public List<Reservation> getReservationsOf(Customer c) {
		return super.getFromForeignKey("fk_idCustomer", c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected Reservation constructObject(ResultSet reservs) throws SQLException {
		return new Reservation(reservs.getInt("idReservation"), reservs.getInt("fk_idCustomer"),
				reservs.getInt("fk_idDepartureFlight"), reservs.getInt("fk_idReturnFlight"),
				reservs.getInt("fk_idHotelRoom"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected Reservation constructObject(int id, HashMap<String, Object> m) {
		return new Reservation(id, (int) m.get("fk_idCustomer"), (int) m.get("fk_idDepartureFlight"),
				(int) m.get("fk_idReturnFlight"), (int) m.get("fk_idHotelRoom"));
	}

	public Reservation createReservation(Customer customer, Flight flight, HotelRoom room) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fk_idCustomer", customer.getId());
		parameters.put("fk_idHotelRoom", flight.getId());
		parameters.put("fk_idFlight", room.getId());

		return super.create(parameters);
	}

}
