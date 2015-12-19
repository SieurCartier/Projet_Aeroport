package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;

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

	public List<Reservation> getReservationsByCustomer(Customer c) {
		return super.getFromForeignKey("fk_idCustomer", c);
	}

	@Override
	protected Reservation constructObject(ResultSet reservs) throws SQLException {
		return new Reservation(reservs.getInt("idReservation"), reservs.getInt("fk_idCustomer"),
				reservs.getInt("fk_idFlight"), reservs.getInt("fk_idHotelRoom"));
	}

	@Override
	protected Reservation constructObject(int id, HashMap<String, Object> m) {
		return new Reservation(id, (int) m.get("fk_idCustomer"), (int) m.get("fk_idFlight"),
				(int) m.get("fk_idHotelRoom"));
	}

}
