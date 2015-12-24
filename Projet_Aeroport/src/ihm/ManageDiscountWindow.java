package ihm;

import domain.AbstractDiscount;
import fabrics.DiscountFabric;
import job.AbstractJob;
import job.DiscountJob;

public class ManageDiscountWindow extends AbstractWindow<DiscountJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<AbstractDiscount, DiscountFabric> getJob() {
		return new DiscountJob();
	}

}
