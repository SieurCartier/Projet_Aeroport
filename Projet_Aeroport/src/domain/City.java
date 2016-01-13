package domain;

import java.util.List;

import fabrics.FlightFabric;
import fabrics.HotelFabric;

/**
 * This class represents a <code>City</code>.
 * 
 * @author Gaston Lemaire
 */
public class City extends DatabaseItem {

	private String name;
	private List<Hotel> hotels = null;
	private List<Flight> departingFlights = null;

	public City(int id, String name) {
		super(id);
		this.name = name;
	}

	/* Getters and Setters */

	/**
	 * This method gets the {@link List} of {@link Hotel} in this
	 * <code>City</code>. It calls the {@link HotelFabric#getHotelsOf(City)}
	 * with this.
	 * 
	 * @return The {@link List} of {@link Hotel} of this <code>City</code>
	 */
	public List<Hotel> getHotels() {
		if (hotels == null)
			hotels = HotelFabric.getInstanceOf().getHotelsOf(this);
		return hotels;
	}

	/**
	 * This method gets the {@link List} of {@link Hotel} in this
	 * <code>City</code>. It calls the {@link HotelFabric#getHotelsOf(City)}
	 * with this.
	 * 
	 * @return The {@link List} of {@link Hotel} of this <code>City</code>
	 */
	public List<Flight> getDepartingFlights() {
		if (departingFlights == null)
			departingFlights = FlightFabric.getInstanceOf().getDepartingFlightsOf(this);
		return departingFlights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* HashCode, Equals and toString */

	/*
	 * (non-Javadoc)
	 * 
	 * @see domaine.DatabaseItem#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domaine.DatabaseItem#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

}
