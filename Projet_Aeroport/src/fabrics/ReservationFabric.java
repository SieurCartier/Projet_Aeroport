package fabrics;

import java.sql.*;
import java.util.*;

import domaine.Reservation;

public class ReservationFabric extends AbstractFabric<Reservation> {
	private static ReservationFabric singleton = null;

	public ReservationFabric() {
		super("Reservation", "idReservation");
	}

	public static ReservationFabric getInstanceOf() {
		if (singleton == null)
			singleton = new ReservationFabric();
		return singleton;
	}

	public List<Reservation> getReservationsByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Reservation constructObject(ResultSet results) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Reservation constructObject(int id, HashMap<String, Object> m) {
		// TODO Auto-generated method stub
		return null;
	}

}
