package utils;

public class NotCreatedHotelRoomException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedHotelRoomException() {
		super("Impossible de créer la chambre d'hotel.");
	}
}
