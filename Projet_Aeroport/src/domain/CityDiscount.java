package domain;

import java.util.Date;
import fabrics.CityFabric;

/**
 * This class represents a Discount which is based on the {@link City} of
 * destination.
 * 
 * @author Gaston Lemaire
 */
public class CityDiscount extends AbstractDiscount implements IDiscount<City> {

	private int idCity;
	private City city = null;

	public CityDiscount(int id, String name, Date startDate, Date endDate,
			float percentage, City city) {
		super(id, name, startDate, endDate, percentage);
		this.idCity = city.getId();
		this.city = city;
	}

	public CityDiscount(int id, String name, Date startDate, Date endDate,
			float percentage, int idCity) {
		super(id, name, startDate, endDate, percentage);
		this.idCity = idCity;
	}

	/**
	 * This method gets the {@link City} on which the Discount is applicable. It
	 * calls the {@link CityFabric#getById(int)} with the #idCity
	 * 
	 * @return The {@link City} of the Discount
	 */
	public City getCity() {
		if (city == null)
			city = CityFabric.getInstanceOf().getById(idCity);
		return city;
	}

	/* HashCode and Equals */

	/*
	 * (non-Javadoc)
	 * 
	 * @see domaine.AbstractDiscount#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCity;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domaine.AbstractDiscount#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityDiscount other = (CityDiscount) obj;
		if (idCity != other.idCity)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.IDiscount#isApplicable(domain.DatabaseItem)
	 */
	@Override
	public boolean isApplicable(City c) {
		return c.equals(getCity()) && new Date().after(startDate)
				&& new Date().before(endDate);
	}
}
