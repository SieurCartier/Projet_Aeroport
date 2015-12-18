package fabrics;

import java.sql.*;
import java.util.WeakHashMap;
import domaine.DatabaseItem;
import utils.InexistantDatabaseItemException;

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

	protected abstract T constructObject(ResultSet results) throws SQLException;

	public void delete(T item) {
		try {
			String requete = "DELETE FROM " + tableName + "WHERE " + primaryKeyName + " = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, item.getId());
			if (pr.executeUpdate() != 1)
				throw new InexistantDatabaseItemException(item);

			removeItem(item);
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void removeItem(T item) {
		objects.remove(item.getId());
	}

	protected void addItem(T item) {
		if (!objects.containsKey(item.getId()))
			objects.put(item.getId(), item);
	}

}
