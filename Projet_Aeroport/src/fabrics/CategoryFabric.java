package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;

public class CategoryFabric extends AbstractFabric<Category> {

	private static CategoryFabric singleton = null;

	public CategoryFabric() {
		super("Categorie", "idCategorie");
	}

	public static CategoryFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CategoryFabric();
		return singleton;
	}

	@Override
	protected Category constructObject(ResultSet categ) throws SQLException {
		return new Category(categ.getInt("idCategorie"), categ.getString("name"), categ.getInt("capacity"),
				categ.getFloat("price"), categ.getInt("fk_idHotel"));
	}

	@Override
	protected Category constructObject(int id, HashMap<String, Object> m) {
		return new Category(id, (String) m.get("name"), (int) m.get("capacity"), (float) m.get("price"),
				(int) m.get("fk_idHotel"));
	}

	public Category createCategory(String name, int capacity, float price, Hotel ownerHotel) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("capacity", capacity);
		parameters.put("price", price);
		parameters.put("fk_idHotel", ownerHotel.getId());
		parameters.put("name", name);

		return super.create(parameters);
	}

	public List<Category> getCategoriesOf(Hotel hotel) {
		return super.getFromForeignKey("fk_idHotel", hotel);
	}

}
