package utils;

import domaine.DatabaseItem;

public class InexistantDatabaseItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public InexistantDatabaseItemException(DatabaseItem item) {
		System.out.println("L'objet suivant n'existe pas dans la BDD : ");
		System.out.println(item);
	}
}
