package domaine;

import java.sql.Timestamp;
import java.util.Date;

import fabrics.CityFabric;

public class Flight extends DatabaseItem {

	private int idDeparture;
	private City departure = null;
	private int idArrival;
	private City arrival = null;
	private Date departureDate;
	private Date arrivalDate;
	private Timestamp flightDuration;
	private int nbFirstClassSits;
	private float priceFirstClassSits;
	private int nbSecondClassSits;
	private float priceSecondClassSits;
	private int nbDayCancelling;

	public Flight(int id, City departure, City arrival, Date departureDate, Date arrivalDate, int nbFirstClassSits,
			float priceFirstClassSits, int nbSecondClassSits, float priceSecondClassSits, int nbDayCancelling) {
		super(id);
		this.idDeparture = departure.getId();
		this.departure = departure;
		this.idArrival = arrival.getId();
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.nbFirstClassSits = nbFirstClassSits;
		this.priceFirstClassSits = priceFirstClassSits;
		this.nbSecondClassSits = nbSecondClassSits;
		this.priceSecondClassSits = priceSecondClassSits;
		this.nbDayCancelling = nbDayCancelling;
		updateDuration();
	}

	public Flight(int id, int idDeparture, int idArrival, Date departureDate, Date arrivalDate, int nbFirstClassSits,
			float priceFirstClassSits, int nbSecondClassSits, float priceSecondClassSits, int nbDayCancelling) {
		super(id);
		this.idDeparture = idDeparture;
		this.idArrival = idArrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.nbFirstClassSits = nbFirstClassSits;
		this.priceFirstClassSits = priceFirstClassSits;
		this.nbSecondClassSits = nbSecondClassSits;
		this.priceSecondClassSits = priceSecondClassSits;
		this.nbDayCancelling = nbDayCancelling;
	}

	public City getDeparture() {
		if (departure == null)
			departure = CityFabric.getInstanceOf().getById(idDeparture);
		return departure;
	}

	public void setDeparture(City departure) {
		this.departure = departure;
	}

	public City getArrival() {
		if (arrival == null)
			arrival = CityFabric.getInstanceOf().getById(idArrival);
		return arrival;
	}

	public void setArrival(City arrival) {
		this.arrival = arrival;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
		updateDuration();
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
		updateDuration();
	}

	public Timestamp getFlightDuration() {
		return flightDuration;
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

	public int getIdDeparture() {
		return idDeparture;
	}

	public int getIdArrival() {
		return idArrival;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((flightDuration == null) ? 0 : flightDuration.hashCode());
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
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (flightDuration == null) {
			if (other.flightDuration != null)
				return false;
		} else if (!flightDuration.equals(other.flightDuration))
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
		return departure.toString() + " -> " + arrival.toString();
	}

	private void updateDuration() {
		flightDuration = new Timestamp(departureDate.getTime() - arrivalDate.getTime());
	}

}
