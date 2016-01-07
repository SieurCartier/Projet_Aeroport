package job;

import java.util.HashMap;

import domain.HotelRoom;
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
	public HotelRoom create(HashMap<String, Object> fields) {
		// TODO Auto-generated method stub
		return null;
	}

}
