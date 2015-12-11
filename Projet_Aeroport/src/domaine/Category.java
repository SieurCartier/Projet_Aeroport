package domaine;

import fabrics.HotelFabric;

public class Category extends DatabaseItem {

	private String name;
	private int capacity;
	private float price;
	private int idOwnerHotel;
	private Hotel ownerHotel = null;

	public Category(int id, String name, int capacity, float price, int idOwnerHotel) {
		super(id);
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.idOwnerHotel = idOwnerHotel;
	}

	public Category(int id, String name, int capacity, float price, Hotel ownerHotel) {
		super(id);
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.idOwnerHotel = ownerHotel.getId();
		this.ownerHotel = ownerHotel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Hotel getOwnerHotel() {
		if (ownerHotel == null)
			ownerHotel = HotelFabric.getInstanceOf().getHotelById(idOwnerHotel);
		return ownerHotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		if (capacity != other.capacity) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
