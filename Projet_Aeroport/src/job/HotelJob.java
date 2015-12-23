package job;

import java.util.HashMap;

import domain.Hotel;
import fabrics.HotelFabric;

/*
 * This class will take care of the fourth use case : "Gestion de la liste des hôtels d'une ville"
 */
public class HotelJob extends AbstractJob<Hotel, HotelFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Hotel create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Hotel t) {
		// TODO Auto-generated method stub

	}

}
