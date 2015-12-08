package domaine;

import java.util.Date;

public class CityDiscount extends AbstractDiscount {

	private City city;

	public CityDiscount(int id, String name, Date startDate, Date endDate, float percentage, City city) {
		super(id, name, startDate, endDate, percentage);
		this.city = city;
	}

	public boolean isApplyable(City c) {
		return city.equals(c) && new Date().after(startDate) && new Date().before(endDate);
	}

}
