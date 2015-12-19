package utils;

public class NotCreatedCityException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedCityException() {
		super("Erreur : la ville n'a pas été créée.");
	}
}
