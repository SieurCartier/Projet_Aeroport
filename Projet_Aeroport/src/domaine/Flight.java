package domaine;

import java.sql.*;
import fabrics.CityFabric;
import utils.DayOfWeek;

/**
 * This class represents a <code>Flight</code>
 * 
 * @author Gaston Lemaire
 */
public class Flight extends DatabaseItem {

	private String flightNumber;
	private int idDeparture;
	private City departure = null;
	private int idArrival;
	private City arrival = null;
	private DayOfWeek dayOfWeekDeparture;
	private Time departureTime;
	private Timestamp flightDuration;
	private int nbFirstClassSits;
	private float priceFirstClassSits;
	private int nbSecondClassSits;
	private float priceSecondClassSits;
	private int nbDayCancelling;

	public Flight(int id, String flightNumber, int idDeparture, int idArrival, DayOfWeek dayOfWeekDeparture,
			Time departureTime, Timestamp flightDuration, int nbFirstClassSits, float priceFirstClassSits,
			int nbSecondClassSits, float priceSecondClassSits, int nbDayCancelling) {
		super(id);
		this.flightNumber = flightNumber;
		this.idDeparture = idDeparture;
		this.idArrival = idArrival;
		this.dayOfWeekDeparture = dayOfWeekDeparture;
		this.departureTime = departureTime;
		this.flightDuration = flightDuration;
		this.nbFirstClassSits = nbFirstClassSits;
		this.priceFirstClassSits = priceFirstClassSits;
		this.nbSecondClassSits = nbSecondClassSits;
		this.priceSecondClassSits = priceSecondClassSits;
		this.nbDayCancelling = nbDayCancelling;
	}

	public Flight(int id, String flightNumber, City departure, City arrival, DayOfWeek dayOfWeekDeparture,
			Time departureTime, Timestamp flightDuration, int nbFirstClassSits, float priceFirstClassSits,
			int nbSecondClassSits, float priceSecondClassSits, int nbDayCancelling) {
		super(id);
		this.flightNumber = flightNumber;
		this.idDeparture = departure.getId();
		this.departure = departure;
		this.idArrival = arrival.getId();
		this.arrival = arrival;
		this.dayOfWeekDeparture = dayOfWeekDeparture;
		this.departureTime = departureTime;
		this.flightDuration = flightDuration;
		this.nbFirstClassSits = nbFirstClassSits;
		this.priceFirstClassSits = priceFirstClassSits;
		this.nbSecondClassSits = nbSecondClassSits;
		this.priceSecondClassSits = priceSecondClassSits;
		this.nbDayCancelling = nbDayCancelling;
	}

	/* Getters and Setters */

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * This method gets the {@link City} of departure of this
	 * <code>Flight</code>. It calls the {@link CityFabric#getById(int)} with
	 * {@link #idDeparture}.
	 * 
	 * @return The {@link City} of departure.
	 */
	public City getDeparture() {
		if (departure == null)
			departure = CityFabric.getInstanceOf().getById(idDeparture);
		return departure;
	}

	/**
	 * This method sets the {@link City} of departure and updates the
	 * {@link #idDeparture}
	 * 
	 * @param departure
	 *            The {@link City} of departure.
	 */
	public void setDeparture(City departure) {
		this.departure = departure;
		this.idDeparture = departure.getId();
	}

	/**
	 * This method gets the {@link City} of arrival of this <code>Flight</code>.
	 * It calls the {@link CityFabric#getById(int)} with {@link #idArrival}.
	 * 
	 * @return The {@link City} of departure.
	 */
	public City getArrival() {
		if (arrival == null)
			arrival = CityFabric.getInstanceOf().getById(idArrival);
		return arrival;
	}

	/**
	 * This method set the {@link City} of arrival and updates the
	 * {@link #idArrival}
	 * 
	 * @param arrival
	 *            The {@link City} of arrival.
	 */
	public void setArrival(City arrival) {
		this.idArrival = arrival.getId();
		this.arrival = arrival;
	}

	/**
	 * This method gets the {@link DayOfWeek} of the departure.
	 * 
	 * @return The {@link DayOfWeek} of the departure
	 */
	public DayOfWeek getDayOfWeekDeparture() {
		return dayOfWeekDeparture;
	}

	/**
	 * This method sets the {@link DayOfWeek} of the departure.
	 * 
	 * @param dayOfWeekDeparture
	 *            The {@link DayOfWeek} of the departure.
	 */
	public void setDayOfWeekDeparture(DayOfWeek dayOfWeekDeparture) {
		this.dayOfWeekDeparture = dayOfWeekDeparture;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Timestamp getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(Timestamp flightDuration) {
		this.flightDuration = flightDuration;
	}

	public int getNbFirstClassSits() {
		return nbFirstClassSits;
	}

	public void setNbFirstClassSits(int nbFirstClassSits) {
		this.nbFirstClassSits = nbFirstClassSits;
	}

	public float getPriceFirstClassSits() {
		return priceFirstClassSits;
	}

	public void setPriceFirstClassSits(float priceFirstClassSits) {
		this.priceFirstClassSits = priceFirstClassSits;
	}

	public int getNbSecondClassSits() {
		return nbSecondClassSits;
	}

	public void setNbSecondClassSits(int nbSecondClassSits) {
		this.nbSecondClassSits = nbSecondClassSits;
	}

	public float getPriceSecondClassSits() {
		return priceSecondClassSits;
	}

	public void setPriceSecondClassSits(float priceSecondClassSits) {
		this.priceSecondClassSits = priceSecondClassSits;
	}

	public int getNbDayCancelling() {
		return nbDayCancelling;
	}

	public void setNbDayCancelling(int nbDayCancelling) {
		this.nbDayCancelling = nbDayCancelling;
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
		result = prime * result + ((dayOfWeekDeparture == null) ? 0 : dayOfWeekDeparture.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightDuration == null) ? 0 : flightDuration.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + idArrival;
		result = prime * result + idDeparture;
		result = prime * result + nbDayCancelling;
		result = prime * result + nbFirstClassSits;
		result = prime * result + nbSecondClassSits;
		result = prime * result + Float.floatToIntBits(priceFirstClassSits);
		result = prime * result + Float.floatToIntBits(priceSecondClassSits);
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
		Flight other = (Flight) obj;
		if (dayOfWeekDeparture != other.dayOfWeekDeparture)
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightDuration == null) {
			if (other.flightDuration != null)
				return false;
		} else if (!flightDuration.equals(other.flightDuration))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (idArrival != other.idArrival)
			return false;
		if (idDeparture != other.idDeparture)
			return false;
		if (nbDayCancelling != other.nbDayCancelling)
			return false;
		if (nbFirstClassSits != other.nbFirstClassSits)
			return false;
		if (nbSecondClassSits != other.nbSecondClassSits)
			return false;
		if (Float.floatToIntBits(priceFirstClassSits) != Float.floatToIntBits(other.priceFirstClassSits))
			return false;
		if (Float.floatToIntBits(priceSecondClassSits) != Float.floatToIntBits(other.priceSecondClassSits))
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
		return flightNumber + " : " + departure.toString() + " -> " + arrival.toString();
	}
}
