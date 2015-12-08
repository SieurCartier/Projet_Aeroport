package utils;

public class InexistantHotelRoomException extends Exception {

	/**
	 * voir avec Rémi
	 */
	private static final long serialVersionUID = 1L;

	public InexistantHotelRoomException() {
		super("La chambre que vous essayez de supprimer n'existe pas.");
	}
}
