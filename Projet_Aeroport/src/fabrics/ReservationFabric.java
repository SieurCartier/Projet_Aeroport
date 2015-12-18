package fabrics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domaine.Reservation;

public class ReservationFabric extends AbstractFabric<Reservation> {
	private static ReservationFabric singleton = null;

	public ReservationFabric() {
		super("", "");
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

}
