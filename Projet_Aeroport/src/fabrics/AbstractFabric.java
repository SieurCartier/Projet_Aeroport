package fabrics;

import java.sql.*;
import java.util.*;
import domaine.DatabaseItem;
import utils.InexistantDatabaseItemException;
import utils.NotCreatedItemException;

public abstract class AbstractFabric<T extends DatabaseItem> {

	protected MySQLConnection co = MySQLConnection.getInstanceOf();
	protected WeakHashMap<Integer, T> objects = new WeakHashMap<Integer, T>();

	private String tableName;
	private String primaryKeyName;

	public AbstractFabric(String tableName, String primaryKeyName) {
		this.tableName = tableName;
		this.primaryKeyName = primaryKeyName;
	}

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

	protected T create(HashMap<String, Object> parameters) {
		T ret = null;

		try {
			String requete = "INSERT INTO " + tableName + " (";

			int i = 0;
			for (String s : parameters.keySet()) {
				requete += s;
				if (i < parameters.size() - 1)
					requete += ", ";
				i++;
			}
			requete += ") VALUES (";

			i = 0;
			for (int j = 0; j < parameters.size(); j++) {
				requete += "?";
				if (j < parameters.size() - 1)
					requete += ", ";
			}
			requete += ")";

			int id;
			PreparedStatement pr = co.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

			int k = 1;
			for (Object param : parameters.values()) {
				pr.setObject(k, param);
				k++;
			}

			pr.executeUpdate();
			ResultSet newIdResult = pr.getGeneratedKeys();
			if (!newIdResult.next())
				throw new NotCreatedItemException();

			id = newIdResult.getInt(1);

			ret = constructObject(id, parameters);
			this.addItem(ret);
			pr.close();
			newIdResult.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ret;
	}

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

	protected void removeItem(T item) {
		objects.remove(item.getId());
	}

	protected void addItem(T item) {
		if (!objects.containsKey(item.getId()))
			objects.put(item.getId(), item);
	}

	protected abstract T constructObject(ResultSet results) throws SQLException;

	protected abstract T constructObject(int id, HashMap<String, Object> m);

}
