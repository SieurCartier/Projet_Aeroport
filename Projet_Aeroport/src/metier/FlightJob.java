package metier;

import java.util.HashMap;

import domaine.Flight;
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
	public Flight create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Flight t) {
		// TODO Auto-generated method stub

	}

}
