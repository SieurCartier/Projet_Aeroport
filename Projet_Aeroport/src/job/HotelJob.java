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
	public Hotel create(HashMap<String, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}



}
