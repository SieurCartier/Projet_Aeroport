package metier;

import java.util.HashMap;
import domaine.Customer;
import fabrics.CustomerFabric;

public class ReservationJob extends AbstractJob<Customer, CustomerFabric> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#create(java.util.HashMap)
	 */
	@Override
	public Customer create(HashMap<String, String> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see metier.AbstractJob#remove(domaine.DatabaseItem)
	 */
	@Override
	public void remove(Customer t) {
		// TODO Auto-generated method stub

	}

}
