package ihm;

import domain.AbstractDiscount;
import job.DiscountJob;

public class NewDiscountWindow extends AbstractNewDatabaseItemWindow<AbstractDiscount, DiscountJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected DiscountJob getJob() {
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
