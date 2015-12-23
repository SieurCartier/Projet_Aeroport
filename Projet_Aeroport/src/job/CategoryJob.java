package job;

import java.util.HashMap;

import domain.Category;
import fabrics.CategoryFabric;

/*
 * This class will take care of the fifth use case : "Gestion des catégories chambres d'un hôtel"
 */
public class CategoryJob extends AbstractJob<Category, CategoryFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Category create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Category t) {
		// TODO Auto-generated method stub

	}

}
