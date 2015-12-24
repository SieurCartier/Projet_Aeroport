package ihm;

import domain.Customer;
import fabrics.CustomerFabric;
import job.AbstractJob;
import job.CustomerJob;

public class NewCustomerWindow extends AbstractNewDatabaseItemWindow<Customer, CustomerJob> {

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
