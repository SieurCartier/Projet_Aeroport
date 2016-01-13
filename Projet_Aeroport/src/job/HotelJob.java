package job;

import java.util.HashMap;
import domain.City;
import domain.Hotel;
import fabrics.HotelFabric;

/**
 * This class will take care of the fourth use case :
 * "Gestion de la liste des hôtels d'une ville"
 */
public class HotelJob extends AbstractJob<Hotel, HotelFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Hotel create(HashMap<String, Object> fields) {
		Hotel ret = null;
		try {
			String name = (String) fields.get("name");
			int reservationDayNumber = Integer.parseInt((String) fields.get("reservationDayNumber"));
			City city = (City) fields.get("city");

			ret = fab.createHotel(city, name, reservationDayNumber);
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
	protected HotelFabric getFabric() {
		return HotelFabric.getInstanceOf();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.IJob#update(domain.DatabaseItem, java.util.HashMap)
	 */
	@Override
	public Hotel update(Hotel item, HashMap<String, Object> fieldsmap) {
		// TODO Auto-generated method stub
		return null;
	}

}
