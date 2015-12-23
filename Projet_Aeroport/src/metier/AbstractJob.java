package metier;

import java.util.HashMap;
import domaine.DatabaseItem;
import fabrics.AbstractFabric;

/**
 * This class represents a generic <code>Job</code> it is parameterized by the
 * {@link DatabaseItem} it will manage and the related {@link AbstractFabric}.
 * 
 * @author Gaston Lemaire
 *
 * @param <T>
 *            The {@link DatabaseItem} managed.
 * @param <F>
 *            The related {@link AbstractFabric}.
 */
public abstract class AbstractJob<T extends DatabaseItem, F extends AbstractFabric<T>> {

	protected F fab;

	/**
	 * This method creates a {@link DatabaseItem} given a field map.
	 * 
	 * @param fields
	 *            A {@link HashMap} containing the values of the windows' fields
	 *            referenced by their attribute name in the class.
	 * @return The new {@link DatabaseItem}.
	 */
	public abstract T create(HashMap<String, String> fields);

	/**
	 * This method removes a {@link DatabaseItem}.
	 * 
	 * @param t
	 *            The {@link DatabaseItem} to remove.
	 */
	public abstract void remove(T t);

}
