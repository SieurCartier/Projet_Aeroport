package ihm;

import job.DiscountJob;

public class ManageDiscountWindow extends AbstractWindow<DiscountJob> {

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

}
