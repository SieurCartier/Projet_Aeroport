package fabrics;

import java.sql.*;

import domaine.Flight;

public class FlightFabric extends AbstractFabric<Flight> {

	private static FlightFabric singleton = null;

	public FlightFabric() {
		super("", "");
	}

	public static FlightFabric getInstanceOf() {
		if (singleton == null)
			singleton = new FlightFabric();
		return singleton;
	}

	@Override
	protected Flight constructObject(ResultSet flight) throws SQLException {
		return new Flight(flight.getInt(""), flight.getInt(""), flight.getInt(""), flight.getDate(""),
				flight.getDate(""), flight.getInt(""), flight.getFloat(""), flight.getInt(""), flight.getFloat(""),
				flight.getInt(""));
	}

}
