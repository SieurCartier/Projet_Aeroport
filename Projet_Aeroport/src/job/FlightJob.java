package job;

import java.util.HashMap;

import domain.Flight;
import fabrics.FlightFabric;

/*
 * This class will take care of the first use case : "Gestion des voyages"
 */
public class FlightJob extends AbstractJob<Flight, FlightFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Flight create(HashMap<String, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

}
