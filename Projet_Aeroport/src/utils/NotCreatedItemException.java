package utils;

public class NotCreatedItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedItemException() {
		super("Création impossible, erreur de BDD");
	}
}
