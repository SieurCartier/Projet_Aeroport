package job;

import java.text.*;
import java.util.*;
import domain.*;
import fabrics.*;

/**
 * This class will take care of the tenth use case : "Gestion des promotions"
 */
public class DiscountJob extends AbstractJob<AbstractDiscount, AbstractFabric<AbstractDiscount>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public AbstractDiscount create(HashMap<String, Object> fields) {

		AbstractDiscount ret = null;

		try {
			String name = (String) fields.get("firstname");

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);

			Date startDate = df.parse((String) fields.get("startDate"));
			Date endDate = df.parse((String) fields.get("endDate"));

			float percentage = 1 - (float) Float.parseFloat((String) fields.get("percentage")) / 100;
			City city = (City) fields.get("city");

			ret = (city != null)
					? CityDiscountFabric.getInstanceOf().createCityDiscount(name, startDate, endDate, percentage, city)
					: AgeDiscountFabric.getInstanceOf().createAgeDiscount(name, startDate, endDate, percentage);

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
	protected AbstractFabric<AbstractDiscount> getFabric() {
		return null;
	}

}
