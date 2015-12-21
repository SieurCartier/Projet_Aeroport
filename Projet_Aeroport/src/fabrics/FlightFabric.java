package fabrics;

import java.sql.*;
import java.util.HashMap;

import domaine.Flight;
import utils.DayOfWeek;

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
		return new Flight(flight.getInt("idFlight"), flight.getString("flightNumber"), flight.getInt("departure"),
				flight.getInt("arrival"), DayOfWeek.valueOf(flight.getString("dayOfWeekDeparture")),
				flight.getTime("departureTime"), flight.getTimestamp("flightDuration"),
				flight.getInt("nbFirstClassSits"), flight.getFloat("priceFirstClassSits"),
				flight.getInt("nbSecondClassSits"), flight.getFloat("priceSecondClassSits"),
				flight.getInt("nbDayCancelling"));
	}

	@Override
	protected Flight constructObject(int id, HashMap<String, Object> m) {
		return new Flight(id, (String) m.get("flightNumber"), (int) m.get("departure"), (int) m.get("arrival"),
				DayOfWeek.valueOf((String) m.get("dayOfWeekDeparture")), (Time) m.get("departureTime"),
				(Timestamp) m.get("flightDuration"), (int) m.get("nbFirstClassSits"),
				(float) m.get("priceFirstClassSits"), (int) m.get("nbSecondClassSits"),
				(float) m.get("priceSecondClassSits"), (int) m.get("nbDayCancelling"));
	}

}
