package metier;

import java.util.HashMap;
import domaine.Category;
import fabrics.CategoryFabric;

/*
 * This class will take care of the fifth use case : "Gestion des catégories chambres d'un hôtel"
 */
public class CategoryJob extends AbstractJob<Category, CategoryFabric> {

	@Override
	public Category create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Category t) {
		// TODO Auto-generated method stub

	}

}
