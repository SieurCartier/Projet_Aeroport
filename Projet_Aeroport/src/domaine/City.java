package domaine;

import java.util.LinkedList;
import java.util.List;

import fabrics.HotelFabric;

public class City extends DatabaseItem {

	private String name;
	private List<Hotel> hotels = null;

	public City(int id, String name) {
		super(id);
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotels == null) ? 0 : hotels.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		if (hotels == null) {
			if (other.hotels != null) {
				return false;
			}
		} else if (!hotels.equals(other.hotels)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
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

	public List<Hotel> getHotels() {
		if (hotels == null)
			hotels = HotelFabric.getInstanceOf().getHotelsOf(this);
		return hotels;
	}

}
