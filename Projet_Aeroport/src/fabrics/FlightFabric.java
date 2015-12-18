package fabrics;

import domaine.Flight;

public class FlightFabric extends GenericFabric<Flight> {

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
	public void SQLquerryById(int id) {
		// TODO Auto-generated method stub

	}

}
