package domaine;

public class HotelRoom extends DatabaseItem {

	private Hotel ownerHotel;
	private String roomNumber;
	private Category cat;

	public HotelRoom(int id, Hotel ownerHotel, String roomNumber, Category cat) {
		super(id);
		this.ownerHotel = ownerHotel;
		this.roomNumber = roomNumber;
		this.cat = cat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cat == null) ? 0 : cat.hashCode());
		result = prime * result + ((ownerHotel == null) ? 0 : ownerHotel.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
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
		if (!(obj instanceof HotelRoom)) {
			return false;
		}
		HotelRoom other = (HotelRoom) obj;
		if (cat == null) {
			if (other.cat != null) {
				return false;
			}
		} else if (!cat.equals(other.cat)) {
			return false;
		}
		if (ownerHotel == null) {
			if (other.ownerHotel != null) {
				return false;
			}
		} else if (!ownerHotel.equals(other.ownerHotel)) {
			return false;
		}
		if (roomNumber == null) {
			if (other.roomNumber != null) {
				return false;
			}
		} else if (!roomNumber.equals(other.roomNumber)) {
			return false;
		}
		return true;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public Hotel getOwnerHotel() {
		return ownerHotel;
	}

	@Override
	public String toString() {
		return "Room number : " + roomNumber + " Category : " + cat.toString();
	}

}
