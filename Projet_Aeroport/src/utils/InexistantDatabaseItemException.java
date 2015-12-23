package utils;

import domain.DatabaseItem;

/**
 * This exception is thrown when a {@link DatabaseItem} is not found in the
 * <code>Database</code>.
 * 
 * @author Gaston Lemaire
 */
public class InexistantDatabaseItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public InexistantDatabaseItemException(DatabaseItem item) {
		System.out.println("L'objet suivant n'existe pas dans la BDD : ");
		System.out.println(item);
	}
}
