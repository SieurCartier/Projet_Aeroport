package fabrics;

import java.sql.*;
import java.util.*;

import domain.*;

/**
 * This class is a <code>Fabric</code> of {@link Category}
 * 
 * @author Gaston Lemaire
 */
public class CategoryFabric extends AbstractFabric<Category> {

	private static CategoryFabric singleton = null;

	public CategoryFabric() {
		super("categorie", "idCategorie");
	}

	public static CategoryFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CategoryFabric();
		return singleton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(java.sql.ResultSet)
	 */
	@Override
	protected Category constructObject(ResultSet categ) throws SQLException {
		return new Category(categ.getInt("idCategorie"),
				categ.getString("name"), categ.getInt("capacity"),
				categ.getFloat("price"), categ.getInt("fk_idHotel"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrics.AbstractFabric#constructObject(int, java.util.HashMap)
	 */
	@Override
	protected Category constructObject(int id, HashMap<String, Object> m) {
		return new Category(id, (String) m.get("name"),
				(int) m.get("capacity"), (float) m.get("price"),
				(int) m.get("fk_idHotel"));
	}

	/**
	 * This method creates a {@link Category}.
	 * 
	 * @param name
	 *            The name of the {@link Category}.
	 * @param capacity
	 *            The capacity of the {@link Category}.
	 * @param price
	 *            The price of the {@link Category}.
	 * @param ownerHotel
	 *            The {@link Hotel} of the {@link Category}.
	 * @return The new {@link Category}.
	 */
	public Category createCategory(String name, int capacity, float price,
			Hotel ownerHotel) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("capacity", capacity);
		parameters.put("price", price);
		parameters.put("fk_idHotel", ownerHotel.getId());
		parameters.put("name", name);

		return super.create(parameters);
	}

	/**
	 * This method gets a {@link List} of {@link Category} of a given
	 * {@link Hotel}.
	 * 
	 * @param hotel
	 *            The {@link Hotel}.
	 * @return The {@link List} of {@link Category}.
	 */
	public List<Category> getCategoriesOf(Hotel hotel) {
		return super.getFromForeignKey("fk_idHotel", hotel);
	}

}
