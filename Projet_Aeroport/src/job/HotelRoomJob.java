package job;

import java.util.HashMap;
import domain.Category;
import domain.Hotel;
import domain.HotelRoom;
import fabrics.HotelRoomFabric;

/**
 * This class will take care of the sixth use case :
 * "Gestion des chambres d'un hôtel"
 */
public class HotelRoomJob extends AbstractJob<HotelRoom, HotelRoomFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public HotelRoom create(HashMap<String, Object> fields) {
		HotelRoom ret = null;
		try {
			String roomNumber = (String) fields.get("roomNumber");
			Category category = (Category) fields.get("category");
			Hotel ownerHotel = (Hotel) fields.get("ownerHotel");

			ret = fab.createHotelRoom(roomNumber, category, ownerHotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected HotelRoomFabric getFabric() {
		return HotelRoomFabric.getInstanceOf();
	}

}
