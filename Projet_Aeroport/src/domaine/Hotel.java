package domaine;

import java.util.List;
import fabrics.*;

/**
 * This class represents a <code>Hotel</code>
 * 
 * @author Shindro
 *
 */
public class Hotel extends DatabaseItem {

	private String name;
	private int reservationDayNumber;
	private int idCity;
	private City city = null;
	private List<HotelRoom> rooms = null;
	private List<Category> categories = null;

	public Hotel(int id, String name, int reservationDayNumber, int idCity) {
		super(id);
		this.name = name;
		this.reservationDayNumber = reservationDayNumber;
		this.idCity = idCity;
	}

	public Hotel(int id, String name, int reservationDayNumber, City city) {
		super(id);
		this.name = name;
		this.reservationDayNumber = reservationDayNumber;
		this.idCity = city.getId();
		this.city = city;
	}

	/* Getters and Setters */

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

	/**
	 * This method gets the {@link City} in which the <code>Hotel</code> stands.
	 * It calls the {@link CityFabric#getById(int)} with {@link #idCity}.
	 * 
	 * @return The {@link City} of the <code>Hotel</code>.
	 */
	public City getCity() {
		if (city == null)
			city = CityFabric.getInstanceOf().getById(idCity);
		return city;
	}

	/**
	 * This method gets the {@link List} of {@link HotelRoom} of this
	 * <code>Hotel</code>. It calls the
	 * {@link HotelRoomFabric#getRoomsOf(Hotel)} with this.
	 * 
	 * @return The {@link List} of {@link HotelRoom} of this <code>Hotel</code>.
	 */
	public List<HotelRoom> getRooms() {
		if (rooms == null)
			rooms = HotelRoomFabric.getInstanceOf().getRoomsOf(this);
		return rooms;
	}

	/**
	 * This method gets the {@link List} of {@link Category} of this
	 * <code>Hotel</code>. It calls the
	 * {@link CategoryFabric#getCategoriesOf(Hotel)} with this.
	 * 
	 * @return The {@link List} of {@link Category} of this <code>Hotel</code>.
	 */
	public List<Category> getCategories() {
		if (categories == null)
			categories = CategoryFabric.getInstanceOf().getCategoriesOf(this);
		return categories;
	}

	/* HashCode, Equals and toString */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + reservationDayNumber;
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
		Hotel other = (Hotel) obj;
		if (idCity != other.idCity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reservationDayNumber != other.reservationDayNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
