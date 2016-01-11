package domain;

import fabrics.*;

/**
 * This class represents a <code>Reservation</code>
 * 
 * @author Gaston Lemaire
 *
 */
public class Reservation extends DatabaseItem {

	private int idCustomer;
	private Customer customer;
	private int idDepartureFlight;
	private Flight departureFlight;
	private int idReturnFlight;
	private Flight returnFlight;
	private int idHotelRoom;
	private HotelRoom room;

	public Reservation(int id, int idCustomer, int idDepartureFlight, int idReturnFlight, int idHotelRoom) {
		super(id);
		this.idCustomer = idCustomer;
		this.idDepartureFlight = idDepartureFlight;
		this.idReturnFlight = idReturnFlight;
		this.idHotelRoom = idHotelRoom;
	}

	public Reservation(int id, Customer customer, Flight departureFlight, Flight returnFlight, HotelRoom room) {
		super(id);
		this.idCustomer = customer.getId();
		this.customer = customer;
		this.idDepartureFlight = departureFlight.getId();
		this.departureFlight = departureFlight;
		this.idReturnFlight = returnFlight.getId();
		this.returnFlight = returnFlight;
		this.room = room;
	}

	/* Getters and Setters */

	/**
	 * This method gets the {@link Customer} that booked the
	 * <code>Reservation</code>. It calls the
	 * {@link CustomerFabric#getById(int)} with {@link #idCustomer}.
	 * 
	 * @return The {@link Customer} that booked the <code>Reservation</code>.
	 */
	public Customer getCustomer() {
		if (customer == null)
			customer = CustomerFabric.getInstanceOf().getById(idCustomer);
		return customer;
	}

	/**
	 * This method gets the {@link Flight} of departure concerned by the
	 * <code>Reservation</code>. It calls the
	 * {@link AbstractFabric#getById(int)} with {@link #idDepartureFlight}.
	 * 
	 * @return The {@link Flight} of departure concerned by the Reservation.
	 */
	public Flight getDepartureFlight() {
		if (departureFlight == null)
			departureFlight = FlightFabric.getInstanceOf().getById(idDepartureFlight);
		return departureFlight;
	}

	public void setDepartureFlight(Flight departureFlight) {
		this.idDepartureFlight = departureFlight.getId();
		this.departureFlight = departureFlight;
	}

	/**
	 * This method gets the {@link Flight} of return concerned by the
	 * <code>Reservation</code>. It calls the
	 * {@link AbstractFabric#getById(int)} with {@link #idReturnFlight}.
	 * 
	 * @return The {@link Flight} of return concerned by the Reservation.
	 */
	public Flight getReturnFlight() {
		if (returnFlight == null)
			returnFlight = FlightFabric.getInstanceOf().getById(idReturnFlight);
		return returnFlight;
	}

	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}

	/**
	 * This method sets the {@link Customer} that booked the
	 * <code>Reservation</code> and updates the {@link #idCustomer}
	 * 
	 * @param customer
	 *            The {@link Customer} that booked the <code>Reservation</code>.
	 */
	public void setCustomer(Customer customer) {
		this.idCustomer = customer.getId();
		this.customer = customer;
	}

	/**
	 * This method gets the {@link HotelRoom} concerned by the
	 * <code>Reservation</code>. It calls the
	 * {@link HotelRoomFabric#getById(int)} with {@link #idHotelRoom}.
	 * 
	 * @return The {@link HotelRoom} concerned by the <code>Reservation</code>.
	 */
	public HotelRoom getRoom() {
		if (room == null)
			room = HotelRoomFabric.getInstanceOf().getById(idHotelRoom);
		return room;
	}

	/**
	 * This method sets the {@link HotelRoom} concerned by the
	 * <code>Reservation</code> and updates the {@link #idHotelRoom}
	 * 
	 * @param room
	 *            The {@link HotelRoom} concerned by the
	 *            <code>Reservation</code>.
	 */
	public void setRoom(HotelRoom room) {
		this.idHotelRoom = room.getId();
		this.room = room;
	}

	/* HashCode, Equals and toString */

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.DatabaseItem#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCustomer;
		result = prime * result + idDepartureFlight;
		result = prime * result + idHotelRoom;
		result = prime * result + idReturnFlight;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see domain.DatabaseItem#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Reservation)) {
			return false;
		}
		Reservation other = (Reservation) obj;
		if (idCustomer != other.idCustomer) {
			return false;
		}
		if (idDepartureFlight != other.idDepartureFlight) {
			return false;
		}
		if (idHotelRoom != other.idHotelRoom) {
			return false;
		}
		if (idReturnFlight != other.idReturnFlight) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getCustomer().toString() + " : " + getDepartureFlight().toString() + " " + getRoom().toString();
	}

}
