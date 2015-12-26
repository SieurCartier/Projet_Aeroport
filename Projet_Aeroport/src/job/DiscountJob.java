package job;

import java.util.HashMap;
import domain.AbstractDiscount;
import fabrics.AbstractFabric;

/*
 * This class will take care of the tenth use case : "Gestion des promotions"
 */
public class DiscountJob extends
		AbstractJob<AbstractDiscount, AbstractFabric<AbstractDiscount>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public AbstractDiscount create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#remove(domain.DatabaseItem)
	 */
	@Override
	public void remove(AbstractDiscount t) {
		// TODO Auto-generated method stub

	}

}
