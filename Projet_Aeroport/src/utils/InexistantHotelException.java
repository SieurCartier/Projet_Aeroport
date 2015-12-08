package utils;

public class InexistantHotelException extends Exception {

	private static final long serialVersionUID = 1L;

	public InexistantHotelException() {
		super("L'hotel que vous souhaitez supprimer n'existe pas.");
	}
}
