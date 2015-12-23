package metier;

import java.util.HashMap;
import domaine.AbstractDiscount;
import fabrics.DiscountFabric;

/*
 * This class will take care of the tenth use case : "Gestion des promotions"
 */
public class DiscountJob extends AbstractJob<AbstractDiscount, DiscountFabric> {

	@Override
	public AbstractDiscount create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(AbstractDiscount t) {
		// TODO Auto-generated method stub

	}

}
