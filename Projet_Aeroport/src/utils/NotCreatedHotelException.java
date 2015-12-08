package utils;

public class NotCreatedHotelException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedHotelException() {
		super("Erreur : l'hotel n'a pas été créé.");
	}

}
