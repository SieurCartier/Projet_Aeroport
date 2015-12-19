package fabrics;

import java.sql.*;
import java.util.HashMap;

import domaine.Flight;

public class FlightFabric extends AbstractFabric<Flight> {

	private static FlightFabric singleton = null;

	public FlightFabric() {
		super("flight", "idFlight");
	}

	public static FlightFabric getInstanceOf() {
		if (singleton == null)
			singleton = new FlightFabric();
		return singleton;
	}

	@Override
	protected Flight constructObject(ResultSet flight) throws SQLException {
		return new Flight(flight.getInt("idFlight"), flight.getInt("departure"), flight.getInt("arrival"),
				flight.getDate("departureDate"), flight.getDate("arrivalDate"), flight.getInt("nbFirstClassSits"),
				flight.getFloat("priceFirstClassSits"), flight.getInt("nbSecondClassSits"),
				flight.getFloat("priceSecondClassSits"), flight.getInt("nbDayCancelling"));
	}

	@Override
	protected Flight constructObject(int id, Object[] m) {
		return new Flight(id, (int) m.get("departure"), (int) m.get("arrival"), (Date) m.get("departureDate"),
				(Date) m.get("arrivalDate"), (int) m.get("nbFirstClassSits"), (float) m.get("priceFirstClassSits"),
				(int) m.get("nbSecondClassSits"), (float) m.get("priceSecondClassSits"),
				(int) m.get("nbDayCancelling"));
	}

}
