package utils;

public class NotCreatedItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedItemException() {
		super("Cr�ation impossible, erreur de BDD");
	}
}
