package domaine;

public class HotelRoom extends DatabaseItem {

	private Hotel ownerHotel;
	private int nbPlaces;
	private float pricePerNight;

	public Hotel getHotel() {
		return ownerHotel;
	}

}
