package metier;

import java.util.HashMap;
import domaine.HotelRoom;
import fabrics.HotelRoomFabric;

/*
 * This class will take care of the sixth use case : "Gestion des chambres d'un hôtel"
 */
public class HotelRoomJob extends AbstractJob<HotelRoom, HotelRoomFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public HotelRoom create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(HotelRoom t) {
		// TODO Auto-generated method stub

	}

}
