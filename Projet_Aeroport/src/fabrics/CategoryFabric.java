package fabrics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import domaine.Category;
import domaine.Hotel;

public class CategoryFabric extends GenericFabric<Category> {

	private static CategoryFabric singleton = null;

	public CategoryFabric() {
		super("Categorie", "idCategorie");
	}

	public static CategoryFabric getInstanceOf() {
		if (singleton == null)
			singleton = new CategoryFabric();
		return singleton;
	}

	public List<Category> getCategoriesOf(Hotel hotel) {
		List<Category> ret = null;
		try {
			ret = new LinkedList<>();
			String requete = "SELECT * " + "FROM Categorie " + "WHERE fk_idHotel = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, hotel.getId());
			ResultSet categories = pr.executeQuery();

			while (categories.next()) {
				Category temp = new Category(categories.getInt("idCategorie"), categories.getString("name"),
						categories.getInt("capacity"), categories.getFloat("price"), hotel);
				if (!objects.containsKey(temp.getId()))
					objects.put(temp.getId(), temp);
				ret.add(temp);
			}
			pr.close();
			categories.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	@Override
	public void SQLquerryById(int id) {
		try {
			String requete = "SELECT * " + "FROM Categorie " + "WHERE idCategorie = ?";
			PreparedStatement pr = co.prepareStatement(requete);
			pr.setInt(1, id);
			ResultSet categ = pr.executeQuery();

			if (categ.next()) {
				Category temp = new Category(categ.getInt("idCategorie"), categ.getString("name"),
						categ.getInt("capacity"), categ.getFloat("price"), categ.getInt("fk_idHotel"));
				objects.put(id, temp);
			}
			pr.close();
			categ.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
