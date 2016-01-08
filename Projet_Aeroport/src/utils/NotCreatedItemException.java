package utils;

import domain.DatabaseItem;

/**
 * This exception is thrown when a {@link DatabaseItem} could not be created.
 * Normally, it corresponds to an error of primary key in the
 * <code>Database</code>.
 * 
 * @author Gaston Lemaire
 */
public class NotCreatedItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotCreatedItemException() {
		super("Création impossible, erreur de BDD");
	}
}
