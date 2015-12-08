package domaine;

import java.util.List;
import fabrics.CityFabric;

public class Hotel extends DatabaseItem {

	private City c;
	private String name;
	private int reservationDayNumber;
	private List<HotelRoom> rooms = null;
	private List<Category> categories = null;

	public Hotel(int id, City c, String name, int reservationDayNumber) {
		super(id);
		this.c = c;
		this.name = name;
		this.reservationDayNumber = reservationDayNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + reservationDayNumber;
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Hotel)) {
			return false;
		}
		Hotel other = (Hotel) obj;
		if (c == null) {
			if (other.c != null) {
				return false;
			}
		} else if (!c.equals(other.c)) {
			return false;
		}
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (reservationDayNumber != other.reservationDayNumber) {
			return false;
		}
		if (rooms == null) {
			if (other.rooms != null) {
				return false;
			}
		} else if (!rooms.equals(other.rooms)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReservationDayNumber() {
		return reservationDayNumber;
	}

	public void setReservationDayNumber(int reservationDayNumber) {
		this.reservationDayNumber = reservationDayNumber;
	}

	public City getC() {
		return c;
	}

	public List<HotelRoom> getRooms() {
		if (rooms == null)
			rooms = CityFabric.getInstanceOf().getRoomsOf(this);
		return rooms;
	}

	public List<Category> getCategories() {
		if (categories == null)
			categories = CityFabric.getInstanceOf().getCategoriesOf(this);
		return categories;
	}

}
