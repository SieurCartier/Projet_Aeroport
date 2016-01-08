package fabrics;

import java.sql.*;
import java.util.HashMap;
import domain.City;
import domain.Flight;
import utils.DayOfWeek;

/**
 * This class is a <code>Fabric</code> of {@link Flight}
 * 
 * @author Gaston Lemaire
 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected Flight constructObject(ResultSet flight) throws SQLException {
		return new Flight(flight.getInt("idFlight"),
				flight.getString("flightNumber"), flight.getInt("departure"),
				flight.getInt("arrival"), DayOfWeek.valueOf(flight
						.getString("dayOfWeekDeparture")),
				flight.getTime("departureTime"),
				flight.getTimestamp("flightDuration"),
				flight.getInt("nbFirstClassSits"),
				flight.getFloat("priceFirstClassSits"),
				flight.getInt("nbSecondClassSits"),
				flight.getFloat("priceSecondClassSits"),
				flight.getInt("nbDayCancelling"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected Flight constructObject(int id, HashMap<String, Object> m) {
		return new Flight(id, (String) m.get("flightNumber"),
				(int) m.get("departure"), (int) m.get("arrival"),
				DayOfWeek.valueOf((String) m.get("dayOfWeekDeparture")),
				(Time) m.get("departureTime"),
				(Timestamp) m.get("flightDuration"),
				(int) m.get("nbFirstClassSits"),
				(float) m.get("priceFirstClassSits"),
				(int) m.get("nbSecondClassSits"),
				(float) m.get("priceSecondClassSits"),
				(int) m.get("nbDayCancelling"));
	}

	public Flight createFlight(String flightNumber, City departure,
			City arrival, DayOfWeek dayOfWeekDeparture, Time departureTime,
			Timestamp flightDuration, int nbFirstClassSits,
			float priceFirstClassSits, int nbSecondClassSits,
			float priceSecondClassSits, int nbDayCancelling) {

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("flightNumber", flightNumber);
		parameters.put("fk_idDepartureCity", departure.getId());
		parameters.put("fk_idArrivalCity", arrival.getId());
		parameters.put("dayOfWeekDeparture", dayOfWeekDeparture.name());
		parameters.put("departureTime", departureTime);
		parameters.put("flightDuration", flightDuration);
		parameters.put("nbFirstClassSits", nbFirstClassSits);
		parameters.put("priceFirstClassSits", priceFirstClassSits);
		parameters.put("nbSecondClassSits", nbSecondClassSits);
		parameters.put("priceSecondClassSits", priceSecondClassSits);
		parameters.put("nbDayCancelling", nbDayCancelling);

		return super.create(parameters);
	}

}
