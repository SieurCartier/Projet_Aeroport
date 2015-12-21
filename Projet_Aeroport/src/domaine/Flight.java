package domaine;

import java.sql.Time;
import java.sql.Timestamp;
import fabrics.CityFabric;
import utils.DayOfWeek;

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
		this.departure = departure;
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

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public City getDeparture() {
		if (departure == null)
			departure = CityFabric.getInstanceOf().getById(idDeparture);
		return departure;
	}

	public void setDeparture(City departure) {
		this.departure = departure;
		this.idDeparture = departure.getId();
	}

	public City getArrival() {
		if (arrival == null)
			arrival = CityFabric.getInstanceOf().getById(idArrival);
		return arrival;
	}

	public void setArrival(City arrival) {
		this.idArrival = arrival.getId();
		this.arrival = arrival;
	}

	public DayOfWeek getDayOfWeekDeparture() {
		return dayOfWeekDeparture;
	}

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

	@Override
	public String toString() {
		return flightNumber + " : " + departure.toString() + " -> " + arrival.toString();
	}
}
