package domaine;

import fabrics.CustomerFabric;
import fabrics.FlightFabric;
import fabrics.HotelRoomFabric;

/**
 * This class represents a <code>Reservation</code>
 * 
 * @author Shindro
 *
 */
public class Reservation extends DatabaseItem {

	private int idCustomer;
	private Customer customer;
	private int idFlight;
	private Flight flight;
	private int idHotelRoom;
	private HotelRoom room;

	public Reservation(int id, int idCustomer, int idFlight, int idHotelRoom) {
		super(id);
		this.idCustomer = idCustomer;
		this.idFlight = idFlight;
		this.idHotelRoom = idHotelRoom;
	}

	public Reservation(int id, Customer customer, Flight flight, HotelRoom room) {
		super(id);
		this.idCustomer = customer.getId();
		this.customer = customer;
		this.idFlight = flight.getId();
		this.flight = flight;
		this.idHotelRoom = room.getId();
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
	 * This method gets the {@link Flight} concerned by the
	 * <code>Reservation</code>. It calls the {@link FlightFabric#getById(int)}
	 * with {@link #idFlight}.
	 * 
	 * @return The {@link Flight} concerned by the <code>Reservation</code>.
	 */
	public Flight getFlight() {
		if (flight == null)
			flight = FlightFabric.getInstanceOf().getById(idFlight);
		return flight;
	}

	/**
	 * This method sets the {@link Flight} concerned by the
	 * <code>Reservation</code> and updates the {@link #idFlight}
	 * 
	 * @param flight
	 *            The {@link Flight} concerned by the <code>Reservation</code>.
	 */
	public void setFlight(Flight flight) {
		this.idFlight = flight.getId();
		this.flight = flight;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCustomer;
		result = prime * result + idFlight;
		result = prime * result + idHotelRoom;
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
		Reservation other = (Reservation) obj;
		if (idCustomer != other.idCustomer)
			return false;
		if (idFlight != other.idFlight)
			return false;
		if (idHotelRoom != other.idHotelRoom)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return customer.toString() + " : " + flight.toString() + " " + room.toString();
	}

}
