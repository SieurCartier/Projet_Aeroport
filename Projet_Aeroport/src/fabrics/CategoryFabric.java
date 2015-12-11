package fabrics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.WeakHashMap;
import domaine.Category;
import domaine.Hotel;

public class CategoryFabric {
	private static CategoryFabric singleton = null;
	private MySQLConnection co = MySQLConnection.getInstanceOf();

	private WeakHashMap<Integer, Category> lesCategories = new WeakHashMap<Integer, Category>();

	private CategoryFabric() {

	}

	public static CategoryFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CategoryFabric();
		return singleton;
	}

	public Category getCategoryById(int idCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> getCategoriesOf(Hotel hotel) {
		List<Category> ret = null;
		try {
			String requete = "SELECT * " + "FROM Categorie " + "WHERE fk_idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, hotel.getId());
			ResultSet categories = pr.executeQuery();

			while (categories.next()) {
				Category temp = new Category(categories.getInt("idCategorie"), categories.getString("name"),
						categories.getInt("capacity"), categories.getFloat("price"), hotel);
				if (!lesCategories.containsKey(temp.getId()))
					lesCategories.put(temp.getId(), temp);
				ret.add(temp);
			}
			pr.close();
			categories.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

}
