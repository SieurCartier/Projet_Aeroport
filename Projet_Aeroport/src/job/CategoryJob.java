package job;

import java.util.HashMap;
import domain.Category;
import domain.Hotel;
import fabrics.CategoryFabric;

/**
 * This class will take care of the fifth use case :
 * "Gestion des catégories chambres d'un hôtel"
 * 
 */

public class CategoryJob extends AbstractJob<Category, CategoryFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Category create(HashMap<String, Object> fields) {

		Category ret = null;

		try {
			String name = (String) fields.get("name");
			int capacity = Integer.parseInt((String) fields.get("capacity"));
			float price = Float.parseFloat((String) fields.get("price"));
			Hotel ownerHotel = (Hotel) fields.get("ownerHotel");

			ret = fab.createCategory(name, capacity, price, ownerHotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#getFabric()
	 */
	@Override
	protected CategoryFabric getFabric() {
		return CategoryFabric.getInstanceOf();
	}

}
