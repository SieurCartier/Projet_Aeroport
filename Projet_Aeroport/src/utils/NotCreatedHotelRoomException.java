package utils;

public class NotCreatedHotelRoomException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedHotelRoomException() {
		super("Impossible de cr�er la chambre d'hotel.");
	}
}
