package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;

public class CategoryFabric extends AbstractFabric<Category> {

	private static CategoryFabric singleton = null;

	private WeakHashMap<Hotel, List<Category>> lesCategories = new WeakHashMap<Hotel, List<Category>>();

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

	@Override
	protected void addItem(Category c) {
		super.addItem(c);
		if (!lesCategories.containsKey(c.getOwnerHotel()))
			lesCategories.put(c.getOwnerHotel(), new LinkedList<Category>());

		lesCategories.get(c.getOwnerHotel()).add(c);
	}

	@Override
	protected void removeItem(Category c) {
		super.removeItem(c);
		if (lesCategories.containsKey(c.getOwnerHotel()))
			lesCategories.get(c.getOwnerHotel()).remove(c);
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
		if (!lesCategories.containsKey(hotel)) {
			try {
				String requete = "SELECT * " + "FROM Categorie " + "WHERE fk_idHotel = ?";
				PreparedStatement pr = co.prepareStatement(requete);
				pr.setInt(1, hotel.getId());
				ResultSet categories = pr.executeQuery();

				while (categories.next()) {
					addItem(constructObject(categories));
				}
				pr.close();
				categories.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return lesCategories.get(hotel);
	}

}
