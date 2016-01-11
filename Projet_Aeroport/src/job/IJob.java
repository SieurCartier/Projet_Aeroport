package job;

import java.util.*;
import domain.DatabaseItem;

public interface IJob<T extends DatabaseItem> {

	/**
	 * This method creates a {@link DatabaseItem} given a field map.
	 * 
	 * @param fields
	 *            A {@link HashMap} containing the values of the windows' fields
	 *            referenced by their attribute name in the class.
	 * @return The new {@link DatabaseItem}.
	 */
	public abstract T create(HashMap<String, Object> fields);

	/**
	 * This method removes a {@link DatabaseItem}.
	 * 
	 * @param t
	 *            The {@link DatabaseItem} to remove.
	 */
	public void remove(T t);

	/**
	 * This method returns the {@link List} of all {@link DatabaseItem} in the
	 * <code>Database</code>.
	 * 
	 * @return The {@link List} of all {@link DatabaseItem}.
	 */
	public List<T> getAll();

}
