package domaine;

import fabrics.CategoryFabric;
import fabrics.HotelFabric;

public class HotelRoom extends DatabaseItem {

	private String roomNumber;
	private int idCategory;
	private Category cat = null;
	private int idOwnerHotel;
	private Hotel ownerHotel = null;

	public HotelRoom(int id, String roomNumber, int idCategory, int idOwnerHotel) {
		super(id);
		this.roomNumber = roomNumber;
		this.idCategory = idCategory;
		this.idOwnerHotel = idOwnerHotel;
	}

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

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Category getCat() {
		if (cat == null)
			cat = CategoryFabric.getInstanceOf().getCategoryById(idCategory);
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Hotel getOwnerHotel() {
		if (ownerHotel == null)
			ownerHotel = HotelFabric.getInstanceOf().getHotelById(idOwnerHotel);
		return ownerHotel;
	}

	@Override
	public String toString() {
		return "Room number : " + roomNumber + " Category : " + cat.toString();
	}

}
