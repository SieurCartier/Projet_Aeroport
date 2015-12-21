package domaine;

import java.util.Date;

import fabrics.CityFabric;

public class CityDiscount extends AbstractDiscount {

	private int idCity;
	private City city = null;

	public CityDiscount(int id, String name, Date startDate, Date endDate, float percentage, City city) {
		super(id, name, startDate, endDate, percentage);
		this.idCity = city.getId();
		this.city = city;
	}

	public CityDiscount(int id, String name, Date startDate, Date endDate, float percentage, int idCity) {
		super(id, name, startDate, endDate, percentage);
		this.idCity = idCity;
	}

	public City getCity() {
		if (city == null)
			city = CityFabric.getInstanceOf().getById(idCity);
		return city;
	}

	public boolean isApplyable(City c) {
		return c.equals(getCity()) && new Date().after(startDate) && new Date().before(endDate);
	}

}
