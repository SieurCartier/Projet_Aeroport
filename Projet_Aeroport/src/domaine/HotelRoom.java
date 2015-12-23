package domaine;

import fabrics.*;

/**
 * This class represents a <code>HotelRoom</code>
 * 
 * @author Shindro
 *
 */
public class HotelRoom extends DatabaseItem {

	private String roomNumber;
	private int idCategory;
	private Category category = null;
	private int idOwnerHotel;
	private Hotel ownerHotel = null;

	public HotelRoom(int id, String roomNumber, int idCategory, int idOwnerHotel) {
		super(id);
		this.roomNumber = roomNumber;
		this.idCategory = idCategory;
		this.idOwnerHotel = idOwnerHotel;
	}

	public HotelRoom(int id, String roomNumber, Category category, Hotel ownerHotel) {
		super(id);
		this.roomNumber = roomNumber;
		this.idCategory = category.getId();
		this.category = category;
		this.idOwnerHotel = ownerHotel.getId();
		this.ownerHotel = ownerHotel;
	}

	/* Getters and Setters */

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * This method gets the {@link Category} of the <code>HotelRoom</code>. It
	 * calls the {@link CategoryFabric#getById(int)} with {@link #idCategory}.
	 * 
	 * @return The {@link Category} of the <code>HotelRoom</code>.
	 */
	public Category getCategory() {
		if (category == null)
			category = CategoryFabric.getInstanceOf().getById(idCategory);
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * This method gets the {@link Hotel} in which the <code>HotelRoom</code>
	 * stands. It calls the {@link HotelFabric#getById(int)} with
	 * {@link #idOwnerHotel}.
	 * 
	 * @return The {@link Hotel} of the <code>HotelRoom</code>.
	 */
	public Hotel getOwnerHotel() {
		if (ownerHotel == null)
			ownerHotel = HotelFabric.getInstanceOf().getById(idOwnerHotel);
		return ownerHotel;
	}

	/* HashCode, Equals and toString */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idCategory;
		result = prime * result + idOwnerHotel;
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
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
		HotelRoom other = (HotelRoom) obj;
		if (idCategory != other.idCategory)
			return false;
		if (idOwnerHotel != other.idOwnerHotel)
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room number : " + roomNumber;
	}

}
