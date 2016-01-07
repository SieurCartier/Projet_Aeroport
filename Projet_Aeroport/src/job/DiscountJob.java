package job;

import java.util.HashMap;
import domain.AbstractDiscount;
import fabrics.AbstractFabric;

/*
 * This class will take care of the tenth use case : "Gestion des promotions"
 */
public class DiscountJob extends AbstractJob<AbstractDiscount, AbstractFabric<AbstractDiscount>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see job.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public AbstractDiscount create(HashMap<String, Object> fields) {

		AbstractDiscount ret = null;

		// String name = (String) fields.get("firstname");
		// Date startDate = (String) fields.get("firstname");
		// Date endDate = (String) fields.get("firstname");
		// float percentage = 1 - Float.parseFloat((String)
		// fields.get("percentage")) / 100;

		return ret;
	}

}
