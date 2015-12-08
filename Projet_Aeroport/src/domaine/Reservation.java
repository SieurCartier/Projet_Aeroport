package domaine;

public class Reservation extends DatabaseItem {

	private Customer customer;
	private Flight flight;
	private HotelRoom room;

	public Reservation(int id, Customer customer, Flight flight, HotelRoom room) {
		super(id);
		this.customer = customer;
		this.flight = flight;
		this.room = room;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public HotelRoom getRoom() {
		return room;
	}

	public void setRoom(HotelRoom room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

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
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (flight == null) {
			if (other.flight != null) {
				return false;
			}
		} else if (!flight.equals(other.flight)) {
			return false;
		}
		if (room == null) {
			if (other.room != null) {
				return false;
			}
		} else if (!room.equals(other.room)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return customer.toString() + " : " + flight.toString() + " " + room.toString();
	}

}
