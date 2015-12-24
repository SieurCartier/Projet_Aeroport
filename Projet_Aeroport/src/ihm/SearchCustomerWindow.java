package ihm;

import domain.Customer;
import fabrics.CustomerFabric;
import job.AbstractJob;
import job.CustomerJob;

public class SearchCustomerWindow extends AbstractWindow<CustomerJob> {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ihm.AbstractWindow#getJob()
	 */
	@Override
	protected AbstractJob<Customer, CustomerFabric> getJob() {
		return new CustomerJob();
	}

}
