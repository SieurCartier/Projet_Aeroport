package fabrics;

import java.sql.PreparedStatement;
import java.util.WeakHashMap;
import domaine.DatabaseItem;
import utils.InexistantDatabaseItemException;

public abstract class GenericFabric<T extends DatabaseItem> {

	protected MySQLConnection co = MySQLConnection.getInstanceOf();
	protected WeakHashMap<Integer, T> objects = new WeakHashMap<Integer, T>();

	private String tableName;
	private String primaryKeyName;

	public GenericFabric(String tableName, String primaryKeyName) {
		this.tableName = tableName;
		this.primaryKeyName = primaryKeyName;
	}

	public T getById(int id) {
		if (!objects.containsKey(id))
			SQLquerryById(id);
		return objects.get(id);
	}

	public void delete(T item) {
		try {
			String requete = "DELETE FROM " + tableName + "WHERE " + primaryKeyName + " = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, item.getId());
			if (pr.executeUpdate() != 1)
				throw new InexistantDatabaseItemException(item);
			objects.remove(item);
			pr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public abstract void SQLquerryById(int id);

}
