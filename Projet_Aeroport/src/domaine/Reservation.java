package domaine;

import fabrics.CustomerFabric;
import fabrics.FlightFabric;
import fabrics.HotelRoomFabric;

public class Reservation extends DatabaseItem {

	private int idCustomer;
	private Customer customer;
	private int idFlight;
	private Flight flight;
	private int idHotelRoom;
	private HotelRoom room;

	public Reservation(int id, Customer customer, Flight flight, HotelRoom room) {
		super(id);
		this.customer = customer;
		this.flight = flight;
		this.room = room;
	}

	public Reservation(int id, int idCustomer, int idFlight, int idHotelRoom) {
		super(id);
		this.idCustomer = idCustomer;
		this.idFlight = idFlight;
		this.idHotelRoom = idHotelRoom;
	}

	public Customer getCustomer() {
		if (customer == null)
			customer = CustomerFabric.getInstanceOf().getById(idCustomer);
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		if (flight == null)
			flight = FlightFabric.getInstanceOf().getById(idFlight);
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public HotelRoom getRoom() {
		if (room == null)
			room = HotelRoomFabric.getInstanceOf().getHotelRoomById(idFlight);
		return room;
	}

	public void setRoom(HotelRoom room) {
		this.room = room;
	}

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
