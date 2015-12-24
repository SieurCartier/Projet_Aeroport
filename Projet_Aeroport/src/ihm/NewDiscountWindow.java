package ihm;

import domain.AbstractDiscount;
import fabrics.DiscountFabric;
import job.AbstractJob;
import job.DiscountJob;

public class NewDiscountWindow extends AbstractNewDatabaseItemWindow<AbstractDiscount, DiscountJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<AbstractDiscount, DiscountFabric> getJob() {
		// TODO Auto-generated method stub
		return new DiscountJob();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractNewDatabaseItemWindow#initComponents()
	 */
	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub

	}

}
