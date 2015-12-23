package domaine;

import java.util.*;
import fabrics.*;

/**
 * This class represents a <code>Customer</code>.
 * 
 * @author Gaston Lemaire
 */
public class Customer extends DatabaseItem {

	private String firstname;
	private String lastname;
	private Date birthdate;
	private int idCity;
	private City city = null;
	private List<Reservation> reservations = null;

	public Customer(int id, String firstname, String lastname, Date birthdate, int idCity) {
		super(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.idCity = idCity;
	}

	public Customer(int id, String firstname, String lastname, Date birthdate, City city) {
		super(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.idCity = city.getId();
		this.city = city;
	}

	/* Getters and Setters */

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * This method gets the {@link City} of this <code>Customer</code>. It calls
	 * the {@link CityFabric#getById(int)} with the {@link #idCity} .
	 * 
	 * @return The {@link City} of the <code>Customer</code>.
	 */
	public City getCity() {
		if (city == null)
			city = CityFabric.getInstanceOf().getById(idCity);
		return city;
	}

	/**
	 * This method gets the {@link List} of {@link Reservation} of this
	 * <code>Customer</code>. It calls the
	 * {@link ReservationFabric#getReservationsOf(Customer)} with this.
	 * 
	 * @return The {@link List} of {@link Reservation} of this
	 *         <code>Customer</code>.
	 */
	public List<Reservation> getReservations() {
		if (reservations == null)
			reservations = ReservationFabric.getInstanceOf().getReservationsOf(this);
		return reservations;
	}

	/**
	 * This method calculates the age of the <code>Customer</code> with its
	 * {@link Customer#birthdate}.
	 * 
	 * @return The age of the <code>Customer</code>.
	 */
	@SuppressWarnings("deprecation")
	public int getAge() {
		return new Date(new Date().getTime() - birthdate.getTime()).getYear();
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
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + idCity;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		Customer other = (Customer) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (idCity != other.idCity)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
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
		return lastname + " " + firstname;
	}
}
