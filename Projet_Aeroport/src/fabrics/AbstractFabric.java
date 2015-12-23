package fabrics;

import java.sql.*;
import java.util.*;

import domaine.DatabaseItem;
import utils.InexistantDatabaseItemException;
import utils.NotCreatedItemException;

/**
 * This class represents a general <code>Fabric</code>. It is parameterized with
 * the item that it is going to manage. It has an internal buffer system such as
 * {@link DatabaseItem} are retrieved from the <code>Database</code> once and
 * stored in a {@link WeakHashMap}.
 * 
 * @author Gaston Lemaire
 *
 * @param <T>
 *            A {@link DatabaseItem} that the <code>Fabric</code> will manage.
 */
public abstract class AbstractFabric<T extends DatabaseItem> {

	protected MySQLConnection co = MySQLConnection.getInstanceOf();
	protected WeakHashMap<Integer, T> objects = new WeakHashMap<Integer, T>();

	private String tableName;
	private String primaryKeyName;

	public AbstractFabric(String tableName, String primaryKeyName) {
		this.tableName = tableName;
		this.primaryKeyName = primaryKeyName;
	}

	/**
	 * This method gets a {@link DatabaseItem} from its buffer and queries the
	 * <code>Database</code> with its <code>id</code> if not found. It uses
	 * {@link PreparedStatement} and generates the query automatically.
	 * 
	 * @param id
	 *            The <code>id</code> of the {@link DatabaseItem}.
	 * @return The object representation of the {@link DatabaseItem}.
	 */
	public T getById(int id) {
		if (!objects.containsKey(id)) {
			try {
				String requete = "SELECT * " + "FROM " + tableName + " WHERE " + primaryKeyName + " = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, id);
				ResultSet results = pr.executeQuery();

				if (results.next())
					objects.put(id, constructObject(results));

				pr.close();
				results.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return objects.get(id);
	}

	/**
	 * This method updates a {@link DatabaseItem} in the <code>Database</code>
	 * and in its internal buffer. It uses {@link PreparedStatement} and
	 * generates the query automatically.
	 * 
	 * @param item
	 *            The {@link DatabaseItem} to update in the
	 *            <code>Database</code>.
	 * @param parameters
	 *            A {@link HashMap} containing the values of the fields to
	 *            update referenced by their field name in the
	 *            <code>Database</code>.
	 */
	protected void update(T item, HashMap<String, Object> parameters) {
		try {
			String requete = "UPDATE " + tableName + " SET ";

			int i = 0;
			for (String s : parameters.keySet()) {
				requete += s + " = ?";
				if (i < parameters.size() - 1)
					requete += ", ";
				i++;
			}
			requete += " WHERE " + primaryKeyName + " = ?";

			PreparedStatement pr = co.prepareStatement(requete);

			int k = 1;
			for (Object param : parameters.values()) {
				pr.setObject(k, param);
				k++;
			}
			pr.setObject(k, item.getId());

			if (pr.executeUpdate() != 1)
				throw new InexistantDatabaseItemException(item);

			this.addItem(item);
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method create a new {@link DatabaseItem} with the parameters given,
	 * stores it in its internal buffer and in the <code>Database</code>. It
	 * uses {@link PreparedStatement} and generates the query automatically.
	 * 
	 * @param fieldMap
	 *            A {@link HashMap} containing the values of the fields needed
	 *            to construct the item referenced by their field name in the
	 *            <code>Database</code>.
	 * @return The new {@link DatabaseItem}.
	 */
	protected T create(HashMap<String, Object> fieldMap) {
		T ret = null;

		try {
			String requete = "INSERT INTO " + tableName + " (";

			int i = 0;
			for (String s : fieldMap.keySet()) {
				requete += s;
				if (i < fieldMap.size() - 1)
					requete += ", ";
				i++;
			}
			requete += ") VALUES (";

			i = 0;
			for (int j = 0; j < fieldMap.size(); j++) {
				requete += "?";
				if (j < fieldMap.size() - 1)
					requete += ", ";
			}
			requete += ")";

			int id;
			PreparedStatement pr = co.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

			int k = 1;
			for (Object param : fieldMap.values()) {
				pr.setObject(k, param);
				k++;
			}

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedItemException();

			id = newIdResult.getInt(1);

			ret = constructObject(id, fieldMap);
			this.addItem(ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ret;
	}

	/**
	 * This method deletes an item from the <code>Database</code> and removes it
	 * from its internal buffer. It uses {@link PreparedStatement} and generates
	 * the query automatically.
	 * 
	 * @param item
	 *            The {@link DatabaseItem} to delete.
	 */
	public void delete(T item) {
		try {
			String requete = "DELETE FROM " + tableName + " WHERE " + primaryKeyName + " = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, item.getId());
			if (pr.executeUpdate() != 1)
				throw new InexistantDatabaseItemException(item);

			this.removeItem(item);
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * A method that allows to retrieve a {@link List} of {@link DatabaseItem}
	 * given another {@link DatabaseItem} based on the foreign key system of the
	 * <code>Database</code>. It uses {@link PreparedStatement} and generates
	 * the query automatically.
	 * 
	 * @param key
	 *            The name of the foreign key in the <code>Database</code>.
	 * @param item
	 *            The {@link DatabaseItem} represented by the foreign key.
	 * @return A {@link List} of {@link DatabaseItem}
	 */
	protected List<T> getFromForeignKey(String key, DatabaseItem item) {
		List<T> ret = null;
		try {
			String requete = "SELECT * FROM " + tableName + "WHERE " + key + " = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, item.getId());
			ResultSet objectFromForeign = pr.executeQuery();

			ret = new LinkedList<T>();
			while (objectFromForeign.next()) {
				T temp = constructObject(objectFromForeign);
				addItem(temp);
				ret.add(temp);
			}
			pr.close();
			objectFromForeign.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	/**
	 * A method that removes a {@link DatabaseItem} from the internal buffer. If
	 * a child has an internal buffer, it is recommended to extend it.
	 * 
	 * @param item
	 *            The {@link DatabaseItem} to remove from the internal buffer.
	 */
	protected void removeItem(T item) {
		objects.remove(item.getId());
	}

	/**
	 * A method that allows to add a {@link DatabaseItem} in the internal
	 * buffer. If a child has an internal buffer, it is recommended to extend
	 * it.
	 * 
	 * @param item
	 *            The {@link DatabaseItem} to add to the internal buffer.
	 */
	protected void addItem(T item) {
		objects.put(item.getId(), item);
	}

	/**
	 * A method called in {@link #getById(int)} and
	 * {@link #getFromForeignKey(String, DatabaseItem)}. It is used to construct
	 * a {@link DatabaseItem} given a {@link ResultSet}.
	 * 
	 * @param results
	 *            The {@link ResultSet} containing every fields retrieved form
	 *            the <code>Database</code>.
	 * @return A {@link DatabaseItem} built from the <code>Database</code>
	 *         fields.
	 * @throws SQLException
	 */
	protected abstract T constructObject(ResultSet results) throws SQLException;

	/**
	 * A method called in {@link #create(HashMap)}. It is used to construct a
	 * {@link DatabaseItem}.
	 * 
	 * @param id
	 *            The <code>id</code> of the {@link DatabaseItem}.
	 * @param fieldMap
	 *            A {@link HashMap} containing the values of the fields needed
	 *            to construct the item referenced by their field name in the
	 *            <code>Database</code>
	 * @return The new {@link DatabaseItem}.
	 */
	protected abstract T constructObject(int id, HashMap<String, Object> fieldMap);

}
