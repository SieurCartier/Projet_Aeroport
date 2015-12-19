package fabrics;

import java.sql.*;
import java.util.*;
import domaine.*;
import utils.Enums;

public class CategoryFabric extends AbstractFabric<Category> {

	private enum ColumnNames {
		capacity, price, fk_idHotel, name
	}

	private static final int CAPACITY = ColumnNames.capacity.ordinal();
	private static final int PRICE = ColumnNames.price.ordinal();
	private static final int FK_ID_HOTEL = ColumnNames.fk_idHotel.ordinal();
	private static final int NAME = ColumnNames.name.ordinal();

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
	protected Category constructObject(int id, Object[] m) {
		return new Category(id, (String) m[NAME], (int) m[CAPACITY], (float) m[PRICE], (int) m[FK_ID_HOTEL]);
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
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(capacity);
		parameters.add(price);
		parameters.add(ownerHotel.getId());
		parameters.add(name);

		return super.create(Enums.toStringArray(ColumnNames.values()), parameters.toArray());
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
